package com.br.uaicoins.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.uaicoins.models.db.Carteira;
import com.br.uaicoins.models.db.Usuario;

@Repository
public interface CarteirasRepository extends CrudRepository<Carteira, Integer>{
	Carteira findByUsuario(Usuario usuario);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE carteira c SET c.saldoDoacao = c.saldoDoacao + ?1")
	void updateSaldoDoacao(BigDecimal valor);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE carteira c SET c.saldoRetirada = c.saldoRetirada - ?2 "
			+ "WHERE c.usuario.id = ?1")
	void updateSaldoRetirada(Integer idUsuario, BigDecimal valor);
}