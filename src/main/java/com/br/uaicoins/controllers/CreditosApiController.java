package com.br.uaicoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.icontrollers.CreditosApi;
import com.br.uaicoins.models.api.CreditoResponse;
import com.br.uaicoins.services.CreditosService;

@RestController
public class CreditosApiController implements CreditosApi {
	
	@Autowired
	private CreditosService creditosService;

	@Override
	public ResponseEntity<List<CreditoResponse>> getCreditos() {
		return new ResponseEntity<List<CreditoResponse>>(creditosService.listarCreditos(), HttpStatus.OK);
	}

}