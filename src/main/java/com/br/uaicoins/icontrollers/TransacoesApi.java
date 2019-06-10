package com.br.uaicoins.icontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.models.api.TransacaoRequest;
import com.br.uaicoins.models.api.TransacaoResponse;

@RestController
@RequestMapping("/transacoes")
public interface TransacoesApi {

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<TransacaoResponse>> getTransacoes();
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<TransacaoResponse> postTransacao(@RequestBody TransacaoRequest transacaoRequest);
}
