package com.bios.conta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bios.conta.model.Conta;
import com.bios.conta.repository.ContaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping(path="/{contaId}")
	public ResponseEntity<?> getItensPorConta(@PathVariable Long contaId) {
		Conta conta = contaRepository.findOne(contaId);
		return ResponseEntity.ok(conta.getItens());
	}
	
}
