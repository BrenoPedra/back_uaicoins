package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoRequest {
	
	private Integer idUsuarioDestino;
    private Integer idUsuarioOrigem;
    private String motivo;
    private BigDecimal valorTransacao;
}
