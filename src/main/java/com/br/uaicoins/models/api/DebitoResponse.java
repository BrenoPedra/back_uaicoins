package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import com.br.uaicoins.models.db.Debito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitoResponse {

	private Integer id;
	private String nomeUsuario;
	private String dataDebito;
	private BigDecimal valorDebito;
	
	public DebitoResponse(Debito debito) {
		this.id = debito.getId();
		this.nomeUsuario = debito.getUsuario().getNome();
		this.dataDebito = String.valueOf(debito.getDataDebito());
		this.valorDebito = debito.getValorDebito();
	}
}
