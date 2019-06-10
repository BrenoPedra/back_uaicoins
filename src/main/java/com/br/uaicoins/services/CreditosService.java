package com.br.uaicoins.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uaicoins.models.api.CreditoResponse;
import com.br.uaicoins.models.db.Credito;
import com.br.uaicoins.repositories.CreditosRepository;

@Service
public class CreditosService {

	@Autowired
	private CreditosRepository creditosRepository;
	
	public List<CreditoResponse> listarCreditos() {
		List<Credito> creditoList = creditosRepository.findAll();
		return creditoList.stream()
				.map(c -> new CreditoResponse(c))
				.collect(Collectors.toList());
	}
}