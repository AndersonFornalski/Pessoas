package com.fornalskiapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fornalskiapp.models.Telefones;

@Repository
public interface TelefonesRepository extends CrudRepository<Telefones, Long>{
	
	@Query("select t from Telefones t where t.pessoa.id = ?1")
	public List<Telefones> getFones(long pessoaId);

}
