package com.exemplo.web.repository;

import java.util.ArrayList;
import java.util.List;

import com.exemplo.web.dto.SalaDto;

public class SalaRepository {
	private List<SalaDto> salas;
	public SalaRepository() {
		this.salas = new ArrayList<>();
	}
	public SalaDto criaSala(SalaDto sala) {
		this.salas.add(sala);
		return sala;
	}
	public List<SalaDto> readSalas() {
		return this.salas;
	}
	public SalaDto alteraSala(SalaDto novaSala) {
		this.salas.stream()
		.filter(sala -> sala.getNome().equals(novaSala.getNome())).findFirst()
		.orElseThrow(() ->)
	}
}
