package br.com.viavarejo.apresentacao.filters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viavarejo.apresentacao.domain.LogRequestResponse;

@Component
@Order(1)
public class RequestResponseLogger implements Filter {

	private final static Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);

	@Autowired
	ObjectMapper om;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		MyCustomHttpRequestWrapper requestWrapper = new MyCustomHttpRequestWrapper((HttpServletRequest) request);
		MyCustomHttpResponseWrapper responseWrapper = new MyCustomHttpResponseWrapper((HttpServletResponse) response);

		chain.doFilter(requestWrapper, responseWrapper);

		LogRequestResponse logRequestResponse = new LogRequestResponse(requestWrapper.getRequestURL().toString(),
				requestWrapper.getRequestURI(), new String(requestWrapper.getByteArray()).replaceAll("\r\n", " "),
				responseWrapper.getStatus(), new String(responseWrapper.getBaos().toByteArray()));
		logger.info(om.writeValueAsString(logRequestResponse));
	}

	private class MyCustomHttpRequestWrapper extends HttpServletRequestWrapper {

		private byte[] byteArray;

		public MyCustomHttpRequestWrapper(HttpServletRequest request) {
			super(request);
			try {
				byteArray = IOUtils.toByteArray(request.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException("Erro no decode do request");
			}
		}

		public byte[] getByteArray() {
			return byteArray;
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			return new MyDelegatingServletInputStream(new ByteArrayInputStream(byteArray));
		}

	}

	private class MyCustomHttpResponseWrapper extends HttpServletResponseWrapper {

		private ByteArrayOutputStream baos = new ByteArrayOutputStream();
		private PrintStream printStream = new PrintStream(baos);

		public MyCustomHttpResponseWrapper(HttpServletResponse response) {
			super(response);
		}

		public ByteArrayOutputStream getBaos() {
			return baos;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return new MyDelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), printStream));
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(new TeeOutputStream(super.getOutputStream(), printStream));
		}

	}
}
