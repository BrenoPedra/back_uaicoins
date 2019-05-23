package com.br.uaicoins.models.api;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Debito {
	
	private Integer id;
    private String nomeUsuario;
    private String dataDebito;
    private BigDecimal valorDebito;

}
