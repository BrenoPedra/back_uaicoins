package com.br.uaicoins.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uaicoins.models.api.DebitoResponse;
import com.br.uaicoins.models.db.Debito;
import com.br.uaicoins.repositories.DebitosRepository;

@Service
public class DebitosService {
	
	@Autowired
	private DebitosRepository debitosRepository;

	public List<DebitoResponse> listarDebitos() {
		List<Debito> debitosList = debitosRepository.findAll();
		return debitosList.stream()
				.map(c -> new DebitoResponse(c))
				.collect(Collectors.toList());
	}
}