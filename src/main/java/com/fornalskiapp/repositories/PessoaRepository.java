package com.fornalskiapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fornalskiapp.models.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
