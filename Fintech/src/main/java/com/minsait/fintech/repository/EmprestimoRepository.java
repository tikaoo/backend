package com.minsait.fintech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.minsait.fintech.entity.Cliente;
import com.minsait.fintech.entity.Emprestimos;

public interface EmprestimoRepository extends JpaRepository<Emprestimos,Integer>{
	List<Emprestimos> findByCliente(Cliente cliente);
	
	Optional<Emprestimos> findByIdEmprestimoAndCliente(Integer idEmprestimo, Cliente cliente);

	 @Query("SELECT COUNT(e) FROM Emprestimos e WHERE e.cliente = :cliente")
	    Integer countByCliente(@Param("cliente") Cliente cliente);
	

}
