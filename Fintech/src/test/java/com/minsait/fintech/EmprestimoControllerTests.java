package com.minsait.fintech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.minsait.fintech.Service.ClienteService;
import com.minsait.fintech.Service.EmprestimoService;
import com.minsait.fintech.controller.EmprestimosController;
import com.minsait.fintech.entity.Cliente;
import com.minsait.fintech.entity.Emprestimos;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmprestimoControllerTests {

@InjectMocks
	
	private EmprestimosController emprestimosController;

	@Mock
	
	private ClienteService clienteService;

	@Mock
	
	private EmprestimoService emprestimoService;
	private Cliente cliente;
	private Emprestimos emprestimo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		cliente = new Cliente();
		cliente.setCpf(new BigInteger("12345678900"));
		cliente.setNome("Joao");
		cliente.setRendaMensal(new BigDecimal("6000"));
		cliente.setLogradouro("Rua dos Bobos");
		cliente.setNumero(0);
		cliente.setQuantidadeEmprestimo(0);
		cliente.setCep("02225000");		
		cliente.setBairro("vila andrade");
		cliente.setCidade("São Paulo");
		cliente.setUf("SP");
	}

	@Test
	public void testBuscarCliente() {
		List<Emprestimos> emprestimos1 = new ArrayList<>();
		emprestimos1.add(emprestimo);

		when(clienteService.buscarClienteCpf(new BigInteger("12345678900"))).thenReturn(cliente);
		when(emprestimoService.buscarPorCliente(cliente)).thenReturn(emprestimos1);
	}

	@Test
	    public void testBuscarEmprestimoCpf() {
	        when(clienteService.buscarClienteCpf(new BigInteger("12345678900"))).thenReturn(cliente);
	        when(emprestimoService.buscarEmprestimoPorIdCliente(1,cliente)).thenReturn(emprestimo);

	        ResponseEntity<Emprestimos> responseEntity = emprestimosController.buscarEmprestimoCpf(1, new BigInteger("12345678900"));
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(emprestimo, responseEntity.getBody());
	    }

	@Test
	    public void testDeleteEmprestimo() {
	        when(clienteService.buscarClienteCpf(new BigInteger("12345678900"))).thenReturn(cliente);

	        ResponseEntity<?> responseEntity = emprestimosController.deleteEmprestimo(1, new BigInteger("12345678900"));
	        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	    }

}
