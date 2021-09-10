package br.com.viavarejo.apresentacao.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.viavarejo.apresentacao.domain.Filial;
import br.com.viavarejo.apresentacao.domain.FilialChave;
import br.com.viavarejo.apresentacao.services.FilialService;

@RestController
@RequestMapping(path = "v1/filial")
public class FilialResource {

	@Autowired
	private FilialService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Filial>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Filial filial) {
		service.save(filial);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filial.getEmpresa())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.POST, path = "findById")
	public ResponseEntity<Filial> findById(@RequestBody FilialChave filialChave) {
		return ResponseEntity.ok().body(service.findById(filialChave));
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody FilialChave filialChave) {
		service.delete(filialChave);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> delete(@RequestBody Filial filial) {
		service.update(filial);
		return ResponseEntity.noContent().build();		
	}
	
}
