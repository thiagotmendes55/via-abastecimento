package br.com.viavarejo.apresentacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viavarejo.apresentacao.domain.Filial;
import br.com.viavarejo.apresentacao.domain.FilialChave;

@Repository
public interface FilialRepository extends JpaRepository<Filial, FilialChave> {

}
