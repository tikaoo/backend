package com.minsait.fintech.entity;

public enum TipoRelacionamento {

	BRONZE {
		@Override
		public double calcularValorFinal(Emprestimos emprestimos) {
			double valorInicial = emprestimos.getValorInicial();
			return valorInicial * 1.80;
		}
	},
	PRATA {
		@Override
		public double calcularValorFinal(Emprestimos emprestimos) {
			double valorInicial = emprestimos.getValorInicial();
			if (valorInicial > 5001) {
				return valorInicial * 1.40;
			} else {
				return valorInicial * 1.60;
			}
		}
	},
	OURO {
		@Override
		public double calcularValorFinal(Emprestimos emprestimos) {
			double valorInicial = emprestimos.getValorInicial();
			int quantidadeEmprestimos = emprestimos.getCliente().getQuantidadeEmprestimo();
			if (quantidadeEmprestimos == 1 || quantidadeEmprestimos == 0) {
				return valorInicial * 1.2;
			} else {
				return valorInicial * 1.3;
			}
		}
	};

	public abstract double calcularValorFinal(Emprestimos emprestimos);
}
