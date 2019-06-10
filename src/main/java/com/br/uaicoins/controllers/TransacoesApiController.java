package com.br.uaicoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.icontrollers.TransacoesApi;
import com.br.uaicoins.models.api.TransacaoRequest;
import com.br.uaicoins.models.api.TransacaoResponse;
import com.br.uaicoins.services.TransacoesService;

@RestController
public class TransacoesApiController implements TransacoesApi{
	
	@Autowired
	private TransacoesService transacoesService;

	@Override
	public ResponseEntity<List<TransacaoResponse>> getTransacoes() {
		return new ResponseEntity<List<TransacaoResponse>>(transacoesService.listarTransacoes(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TransacaoResponse> postTransacao(TransacaoRequest transacaoRequest) {
		return new ResponseEntity<TransacaoResponse>(transacoesService.salvarTransacao(transacaoRequest), HttpStatus.OK);
	}

}