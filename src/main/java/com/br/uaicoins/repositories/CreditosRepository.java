package com.br.uaicoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.uaicoins.models.db.Credito;

@Repository
public interface CreditosRepository extends CrudRepository<Credito, Integer> {

	@Override
	List<Credito> findAll();
}