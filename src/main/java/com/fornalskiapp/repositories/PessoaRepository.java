package com.fornalskiapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fornalskiapp.models.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	@Query("select p from Pessoa p where p.nome like %?1% ")
	List<Pessoa> findPessoaByName(String nome);
}
