package com.br.uaicoins.models.api;

import com.br.uaicoins.models.db.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

	private Integer id;
	private String nomeUsuario;
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeUsuario = usuario.getNome();
	}
}
