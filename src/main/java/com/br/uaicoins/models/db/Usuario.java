package com.br.uaicoins.models.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "login")
    private String login;
	
	@Column(name = "senha")
    private String senha;
	
	@Column(name = "admin")
    private Boolean admin;
}
