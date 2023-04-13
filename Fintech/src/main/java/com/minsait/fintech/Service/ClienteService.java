package com.minsait.fintech.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.minsait.fintech.entity.Cliente;
import com.minsait.fintech.repository.ClienteRepository;
import com.minsait.fintech.repository.EmprestimoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private final EmprestimoRepository emprestimoRepository;
	
	public ClienteService(@Qualifier("clienteRepository") ClienteRepository clienteRepository,
			@Qualifier("emprestimoRepository") EmprestimoRepository emprestimoRepository) {
		this.clienteRepository = clienteRepository;
		this.emprestimoRepository = emprestimoRepository;
		
	}
	private static final String MSG_CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado!";

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarClienteCpf(@CPF BigInteger cpf) {
		Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
		return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format(MSG_CLIENTE_NAO_ENCONTRADO, cpf)));
	}		
	public Cliente salvarCliente(Cliente cliente) {
	    if (clienteRepository.existsByCpf(cliente.getCpf())) {
	        throw new RuntimeException("CPF já cadastrado!");
	    }
	    if (cliente.getCpf().equals(BigInteger.ZERO)) {
	        throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF inválido!");
	    }
	    return clienteRepository.save(cliente);
	}
	
	public Cliente atualizarCliente(Cliente cliente) {
	        return clienteRepository.save(cliente);
	}

	public ResponseEntity<Void> deletarCliente(@CPF BigInteger cpf) {
		Cliente cliente = buscarClienteCpf(cpf);
	    if (cliente == null) {
	        return ResponseEntity.notFound().build();
	    }
		clienteRepository.deleteById(cpf);
		return ResponseEntity.noContent().build();
	}

	@Transactional
	public void updateQtdeEmprestido() {
		List<Cliente> clientes = clienteRepository.findAll();
		for (Cliente cliente : clientes) {
			cliente.setQuantidadeEmprestimo(emprestimoRepository.countByCliente(cliente));
			clienteRepository.save(cliente);
		}
	}
}
