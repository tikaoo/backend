package com.minsait.fintech.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.fintech.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,BigInteger> {
	Optional<Cliente> findByCpf(BigInteger cpf);
	boolean existsByCpf(BigInteger cpf);

}