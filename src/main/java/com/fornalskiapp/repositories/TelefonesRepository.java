package com.fornalskiapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fornalskiapp.models.Telefones;

@Repository
public interface TelefonesRepository extends CrudRepository<Telefones, Long>{

}
