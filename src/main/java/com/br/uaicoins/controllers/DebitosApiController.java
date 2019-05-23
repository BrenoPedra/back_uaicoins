package com.br.uaicoins.controllers;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.uaicoins.icontrollers.DebitosApi;
import com.br.uaicoins.models.api.Debito;

public class DebitosApiController implements DebitosApi {

	@Override
	public ResponseEntity<List<Debito>> getDebitos() {
		Debito debito = new Debito();
		debito.setId(1);
		debito.setNomeUsuario("Nome do Usuário");
		debito.setValorDebito(BigDecimal.TEN);
		debito.setDataDebito("2019-01-01");
		
		return new ResponseEntity<List<Debito>>(Collections.singletonList(debito), HttpStatus.OK);
	}

}
