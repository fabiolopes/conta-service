package com.bios.conta.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bios.conta.model.Conta;
import com.bios.conta.repository.ContaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public ResponseEntity<?> getContas(){
		List<Conta> contas = contaRepository.getContasQuinzena();
		return ResponseEntity.ok(contas);
	}
	
	@GetMapping(path="/{inicio}/{fim}")
	public ResponseEntity<?> getContasPorFiltroData(@PathVariable Date inicio, 
			@PathVariable Date fim){
		List<Conta> contas = contaRepository.getContasPorFiltroData(inicio, fim);
		return ResponseEntity.ok(contas);
	}
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<?> adicionarConta(@RequestBody Conta conta){
		Conta contaSalva = contaRepository.save(conta);
		return ResponseEntity.ok(contaSalva);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> excluirConta(@PathVariable Long id) throws Exception{
		try{
			contaRepository.delete(id);
			return ResponseEntity.ok("Conta Deletada com sucesso.");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possível excluir a conta. Tente mais tarde.");
		}
	}
	
}
