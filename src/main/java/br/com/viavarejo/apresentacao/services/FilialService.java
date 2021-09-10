package br.com.viavarejo.apresentacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.viavarejo.apresentacao.domain.Filial;
import br.com.viavarejo.apresentacao.domain.FilialChave;
import br.com.viavarejo.apresentacao.repositories.FilialRepository;

@Service
public class FilialService {
	
	@Autowired
	private FilialRepository repo;
	
	public void save(Filial filial) {
		repo.save(filial);
	}
	
	public Filial findById(FilialChave filialChave) {
		Filial filial = repo.findById(filialChave).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
		
		return filial;		
	}

	public Page<Filial> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void delete(FilialChave filialChave) {
		repo.deleteById(filialChave);		
	}
	
	public void update(Filial filial) {
	    this.findById(new FilialChave(filial.getEmpresa(), filial.getFilial(), filial.getTipoDeAtividade()));
		repo.save(filial);
	}
	
}
