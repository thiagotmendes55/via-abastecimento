package br.com.viavarejo.apresentacao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.viavarejo.apresentacao.domain.Estado;
import br.com.viavarejo.apresentacao.services.EstadoService;

@RestController
@RequestMapping(path = "v1/estado")
public class EstadoResource {

	@Autowired
	private EstadoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Estado estado) {
		service.save(estado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado.getUf())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{uf}")
	public ResponseEntity<Estado> findById(@PathVariable(name = "uf") String uf) {
		return ResponseEntity.ok().body(service.findById(uf));
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{uf}")
	public ResponseEntity<Void> delete(@PathVariable(name = "uf") String uf) {
		service.delete(uf);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{uf}")
	public ResponseEntity<Void> delete(@PathVariable(name = "uf") String uf, @RequestBody Estado estado) {
		service.update(uf, estado);
		return ResponseEntity.noContent().build();		
	}
	
}
