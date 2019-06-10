package com.br.uaicoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.uaicoins.models.db.Transacao;
import com.br.uaicoins.models.db.Usuario;

@Repository
public interface TransacoesRepository extends CrudRepository<Transacao, Integer> {
	
	List<Transacao> findByUsuarioOrigemOrUsuarioDestinoOrderByDataTransacaoDesc(Usuario usuarioOrigem, Usuario usuarioDestino);
	List<Transacao> findAllByOrderByDataTransacaoDesc();
}