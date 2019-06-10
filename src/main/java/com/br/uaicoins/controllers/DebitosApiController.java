package com.br.uaicoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.icontrollers.DebitosApi;
import com.br.uaicoins.models.api.DebitoResponse;
import com.br.uaicoins.services.DebitosService;

@RestController
public class DebitosApiController implements DebitosApi {
	
	@Autowired
	private DebitosService debitosService;

	@Override
	public ResponseEntity<List<DebitoResponse>> getDebitos() {
		return new ResponseEntity<List<DebitoResponse>>(debitosService.listarDebitos(), HttpStatus.OK);
	}

}