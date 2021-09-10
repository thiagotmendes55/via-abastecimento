package br.com.viavarejo.apresentacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viavarejo.apresentacao.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String> {

}
