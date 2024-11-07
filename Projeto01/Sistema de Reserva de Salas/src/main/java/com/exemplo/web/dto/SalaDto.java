package com.exemplo.web.dto;

public class SalaDto {
	private String nome;
	private Integer capacidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
}
// Cadastro de salas e reservas com controle de disponibilidade.