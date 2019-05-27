package com.br.uaicoins.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uaicoins.models.api.CarteiraResponse;
import com.br.uaicoins.models.api.DepositoEmpresaRequest;
import com.br.uaicoins.models.api.RetiradaRequest;
import com.br.uaicoins.models.api.TransacaoResponse;
import com.br.uaicoins.models.api.UsuarioResponse;
import com.br.uaicoins.models.db.Carteira;
import com.br.uaicoins.models.db.Transacao;
import com.br.uaicoins.models.db.Usuario;
import com.br.uaicoins.repositories.CarteirasRepository;
import com.br.uaicoins.repositories.TransacoesRepository;
import com.br.uaicoins.repositories.UsuariosRepository;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepoitory;
	
	@Autowired
	private CarteirasRepository carteirasRepository;
	
	@Autowired
	private TransacoesRepository transacoesRepository;

	public List<UsuarioResponse> listarUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) usuariosRepoitory.findAll();
		
		return usuarios.stream()
		.map(u -> new UsuarioResponse(u))
		.collect(Collectors.toList());
	}
	
	public UsuarioResponse listarUsuario(Integer idUsuario) {
		return new UsuarioResponse(usuariosRepoitory.findById(idUsuario).get());
	}
	
	public CarteiraResponse listarCarteira(Integer idUsuario) {
		Optional<Usuario> usuario = usuariosRepoitory.findById(idUsuario);
		Carteira carteira = carteirasRepository.findByUsuario(usuario.get());
		return new CarteiraResponse(carteira);
	}
	
	public List<TransacaoResponse> listarTransacoesUsuario(Integer idUsuario) {
		Optional<Usuario> usuario = usuariosRepoitory.findById(idUsuario);
		List<Transacao> transacoes = transacoesRepository.
				findByUsuarioOrigemOrUsuarioDestinoOrderByDataTransacaoDesc(usuario.get(), usuario.get());
		
		return transacoes.stream()
				.map(t -> new TransacaoResponse(t))
				.collect(Collectors.toList());
	}
	
	public void depositarCoinsUsuarios(DepositoEmpresaRequest depositoEmpresaRequest) {
		carteirasRepository.updateSaldoDoacao(depositoEmpresaRequest.getValor());
	}
	
	public void retirarCoinsUsuarios(Integer idUsuario, RetiradaRequest retiradaRequest) {
		carteirasRepository.updateSaldoRetirada(idUsuario, retiradaRequest.getValor());
	}
}