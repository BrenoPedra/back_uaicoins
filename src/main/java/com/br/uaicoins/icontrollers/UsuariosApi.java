package com.br.uaicoins.icontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.models.api.CarteiraResponse;
import com.br.uaicoins.models.api.DepositoEmpresaRequest;
import com.br.uaicoins.models.api.RetiradaRequest;
import com.br.uaicoins.models.api.TransacaoResponse;
import com.br.uaicoins.models.api.UsuarioResponse;

@RestController
@RequestMapping("/usuarios")
public interface UsuariosApi {
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<UsuarioResponse>> getUsuarios();
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UsuarioResponse> getUsuario(@PathVariable("id") Integer idUsuario);
	
	@GetMapping(value = "/{id}/coins", produces = "application/json")
	public ResponseEntity<CarteiraResponse> getCoinsUsuario(@PathVariable("id") Integer idUsuario);
	
	@PutMapping(value = "/{id}/coins", produces = "application/json")
	public ResponseEntity<Void> putCoinsUsuario(@PathVariable("id") Integer idUsuario, @RequestBody RetiradaRequest retiradaRequest);
	
	@GetMapping(value = "/{id}/transacoes", produces = "application/json")
	public ResponseEntity<List<TransacaoResponse>> getTransacoesUsuario(@PathVariable("id") Integer idUsuario);
	
	@PutMapping(value = "/coins", consumes = "application/json")
	public ResponseEntity<Void> putDepositarUsuarioCoins(@RequestBody DepositoEmpresaRequest depositoEmpresaRequest);

}