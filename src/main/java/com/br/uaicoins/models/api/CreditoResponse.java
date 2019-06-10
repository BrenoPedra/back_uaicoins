package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import com.br.uaicoins.models.db.Credito;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditoResponse {
	
	private Integer id;
	private String dataCredito;
	private BigDecimal valorCredito;
	
	public CreditoResponse(Credito credito) {
		this.id = credito.getId();
		this.dataCredito = String.valueOf(credito.getDataCredito());
		this.valorCredito = credito.getValorCredito();
	}
}