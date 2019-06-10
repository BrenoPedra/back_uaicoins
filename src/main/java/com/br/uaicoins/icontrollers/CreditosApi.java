package com.br.uaicoins.icontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.models.api.CreditoResponse;

@RestController
@RequestMapping("/creditos")
public interface CreditosApi {

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CreditoResponse>> getCreditos();
}