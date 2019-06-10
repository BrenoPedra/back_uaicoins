package com.br.uaicoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.uaicoins.models.db.Debito;

@Repository
public interface DebitosRepository extends CrudRepository<Debito, Integer> {

	@Override
	List<Debito> findAll();
}
