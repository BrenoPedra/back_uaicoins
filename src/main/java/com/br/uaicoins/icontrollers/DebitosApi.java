package com.br.uaicoins.icontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.models.api.Debito;

@RestController(value = "/debitos")
public interface DebitosApi {
	
	@GetMapping
	public ResponseEntity<List<Debito>> getDebitos();

}