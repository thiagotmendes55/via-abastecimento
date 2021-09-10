package br.com.viavarejo.apresentacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.apresentacao.domain.Estado;
import br.com.viavarejo.apresentacao.repositories.EstadoRepository;
import br.com.viavarejo.apresentacao.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public void save(Estado estado) {
		repo.save(estado);
	}
	
	public Estado findById(String uf) {
		Estado estado = repo.findById(uf).orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado"));
		
		return estado;		
	}

	public List<Estado> findAll() {
		return repo.findAll();
	}

	public void delete(String uf) {
		this.findById(uf);
		repo.deleteById(uf);		
	}
	
	public void update(String uf, Estado estado) {
	    this.findById(uf);
	    estado.setUf(uf);
		repo.save(estado);
	}
	
}
