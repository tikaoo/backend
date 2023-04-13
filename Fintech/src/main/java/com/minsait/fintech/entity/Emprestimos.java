package com.minsait.fintech.entity;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emprestimos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmprestimo;
	@NumberFormat(pattern = "#.##0,00")
	@Column(length = 100)
	private double valorInicial;
	@NumberFormat(pattern = "#.##0,00")
	@Column( length = 100)
	private double valorFinal;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(columnDefinition = "date")
	private Date dataInicial;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(columnDefinition = "date")
	private Date dataFinal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cpfCliente")
	@JsonBackReference
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	private TipoRelacionamento relacionamento;
	
	@PostPersist
    @PostRemove
    private void updateQtdeEmprestido() {
        cliente.updateQtdeEmprestido();
    }
	@JsonGetter("cpfCliente")
    public BigInteger getCpf() {
        return cliente.getCpf();
    }
}
