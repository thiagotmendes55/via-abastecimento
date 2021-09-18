package br.com.viavarejo.apresentacao.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class LogRequestResponse implements Serializable {
	
	private static final long serialVersionUID = 4466166295458432882L;
	
	private String url;
	private String uri;
	private String request;
	private Integer status;
	private String response;
	private Long dataLog;
	
	public LogRequestResponse() {
		super();
	}

	public LogRequestResponse(String url, String uri, String request, Integer status, String response) {
		super();
		this.uri = uri;
		this.url = url;
		this.request = request;
		this.status = status;
		this.response = response;
		this.dataLog = System.currentTimeMillis();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	public String getDataLog() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		return sdf.format(dataLog);
	}
		
}
