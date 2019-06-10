package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import com.br.uaicoins.models.db.Carteira;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarteiraResponse {
	
	private String nomeUsuario;
	private BigDecimal saldoRetirada;
	private BigDecimal saldoDoacao;

	public CarteiraResponse(Carteira carteira) {
		this.nomeUsuario = carteira.getUsuario().getNome();
		this.saldoRetirada = carteira.getSaldoRetirada();
		this.saldoDoacao = carteira.getSaldoDoacao();
	}
}
