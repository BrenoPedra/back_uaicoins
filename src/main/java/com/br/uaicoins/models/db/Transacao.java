package com.br.uaicoins.models.db;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "transacao")
public class Transacao {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_destino")
	private Usuario usuarioDestino;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_origem")
	private Usuario usuarioOrigem;
	
	@Column(name = "valor_transacao")
	private BigDecimal valorTransacao;
	
	@Column(name = "motivo")
	private String motivo;
	
	@Column(name = "data_transacao")
	private Date dataTransacao;
}
