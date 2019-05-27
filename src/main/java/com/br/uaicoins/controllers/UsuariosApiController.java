package com.br.uaicoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.br.uaicoins.icontrollers.UsuariosApi;
import com.br.uaicoins.models.api.CarteiraResponse;
import com.br.uaicoins.models.api.DepositoEmpresaRequest;
import com.br.uaicoins.models.api.RetiradaRequest;
import com.br.uaicoins.models.api.TransacaoResponse;
import com.br.uaicoins.models.api.UsuarioResponse;
import com.br.uaicoins.services.UsuariosService;

@RestController
public class UsuariosApiController implements UsuariosApi {
	
	@Autowired
	private UsuariosService usuariosService;

	@Override
	public ResponseEntity<List<UsuarioResponse>> getUsuarios() {
		return new ResponseEntity<List<UsuarioResponse>>(usuariosService.listarUsuarios(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioResponse> getUsuario(Integer idUsuario) {
		return new ResponseEntity<UsuarioResponse>(usuariosService.listarUsuario(idUsuario), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<CarteiraResponse> getCoinsUsuario(Integer idUsuario) {
		return new ResponseEntity<CarteiraResponse>(usuariosService.listarCarteira(idUsuario), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TransacaoResponse>> getTransacoesUsuario(Integer idUsuario) {
		return new ResponseEntity<List<TransacaoResponse>>(usuariosService.listarTransacoesUsuario(idUsuario), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> putDepositarUsuarioCoins(DepositoEmpresaRequest depositoEmpresaRequest) {
		usuariosService.depositarCoinsUsuarios(depositoEmpresaRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> putCoinsUsuario(Integer idUsuario, RetiradaRequest retiradaRequest) {
		usuariosService.retirarCoinsUsuarios(idUsuario, retiradaRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}