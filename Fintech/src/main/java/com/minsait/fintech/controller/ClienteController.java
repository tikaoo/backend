package com.minsait.fintech.controller;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.fintech.Service.ClienteService;
import com.minsait.fintech.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Post", description = "Este endpoint permite a criação, a listagem, atualização e exclusão de um cliente.")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/fintech/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;

	}
	@Operation(summary = "Listar todos os clientes")
	@GetMapping
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return clientes;
	}
	@Operation(summary = "Listar cliente por CPF")
	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> buscarClienteCpf(@CPF @PathVariable BigInteger cpf) {
		Cliente cliente = clienteService.buscarClienteCpf(cpf);
		return ResponseEntity.ok().body(cliente);
	}
	@Operation(summary = "Salvar um cliente")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvarCliente(@RequestBody @Validated Cliente clientes) {
		Cliente clienteSalvo = clienteService.salvarCliente(clientes);
		return ResponseEntity.ok().body(clienteSalvo);
	}
	@Operation(summary = "Atualizar um cliente")
	@PutMapping("/{cpf}")
	public ResponseEntity<Cliente> atualizarCliente(@CPF @PathVariable BigInteger cpf, @RequestBody @Validated Cliente cliente) {
		Cliente clienteAtual = clienteService.buscarClienteCpf(cpf);

		if (clienteAtual == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(cliente, clienteAtual, "cpf","quantidadeEmprestimo",
			    "emprestimo","numero");
		clienteService.updateQtdeEmprestido();
		clienteService.atualizarCliente(clienteAtual);

		return ResponseEntity.ok().body(clienteAtual);
	}
	@Operation(summary = "Deletar um cliente")
	@DeleteMapping("/{cpf}")
	public ResponseEntity<Void> deletarCliente(@CPF @PathVariable BigInteger cpf) {
		clienteService.deletarCliente(cpf);
		clienteService.updateQtdeEmprestido();
		return ResponseEntity.noContent().build();
	}
}
