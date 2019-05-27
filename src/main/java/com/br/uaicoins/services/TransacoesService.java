package com.br.uaicoins.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uaicoins.models.api.TransacaoRequest;
import com.br.uaicoins.models.api.TransacaoResponse;
import com.br.uaicoins.models.db.Carteira;
import com.br.uaicoins.models.db.Transacao;
import com.br.uaicoins.models.db.Usuario;
import com.br.uaicoins.repositories.CarteirasRepository;
import com.br.uaicoins.repositories.TransacoesRepository;
import com.br.uaicoins.repositories.UsuariosRepository;

@Service
public class TransacoesService {
	
	@Autowired
	private TransacoesRepository transacoesRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private CarteirasRepository carteirasRepository;

	public List<TransacaoResponse> listarTransacoes() {
		List<Transacao> transacoes = (List<Transacao>) transacoesRepository.findAllByOrderByDataTransacaoDesc();
		return transacoes.stream()
				.map(t -> new TransacaoResponse(t))
				.collect(Collectors.toList());
	}
	
	public TransacaoResponse salvarTransacao(TransacaoRequest transacaoRequest) {
		Transacao transacao = new Transacao();
		transacao.setDataTransacao(new Date());
		transacao.setMotivo(transacaoRequest.getMotivo());
		transacao.setValorTransacao(transacaoRequest.getValorTransacao());
		transacao.setUsuarioOrigem(usuariosRepository.findById(transacaoRequest.getIdUsuarioOrigem()).get());
		transacao.setUsuarioDestino(usuariosRepository.findById(transacaoRequest.getIdUsuarioDestino()).get());
		
		Transacao transacaoSaved = transacoesRepository.save(transacao);
		this.atualizarSaldosTransacao(transacaoSaved.getValorTransacao(), 
				transacaoSaved.getUsuarioOrigem(), transacaoSaved.getUsuarioDestino());
		
		return new TransacaoResponse(transacaoSaved);
	}
	
	private void atualizarSaldosTransacao(BigDecimal valor, Usuario usuarioOrigem, Usuario usuarioDestino) {
		Carteira carteiraUsuarioOrigem = carteirasRepository.findByUsuario(usuarioOrigem);
		Carteira carteiraUsuarioDestino = carteirasRepository.findByUsuario(usuarioDestino);
		
		carteiraUsuarioOrigem.setSaldoDoacao(carteiraUsuarioOrigem.getSaldoDoacao().subtract(valor));
		carteiraUsuarioDestino.setSaldoRetirada(carteiraUsuarioDestino.getSaldoRetirada().add(valor));
		
		carteirasRepository.save(carteiraUsuarioOrigem);
		carteirasRepository.save(carteiraUsuarioDestino);
	}
}