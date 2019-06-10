package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import com.br.uaicoins.models.db.Transacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoResponse {
	
	private Integer id;
	private String nomeUsuarioOrigem;
	private String nomeUsuarioDestino;
	private String motivo;
	private BigDecimal valorTransacao;
	private String dataTransacao;
	
	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getId();
		this.nomeUsuarioOrigem = transacao.getUsuarioOrigem().getNome();
		this.nomeUsuarioDestino = transacao.getUsuarioDestino().getNome();
		this.motivo = transacao.getMotivo();
		this.valorTransacao = transacao.getValorTransacao();
		this.dataTransacao = transacao.getDataTransacao().toString();
	}
}
