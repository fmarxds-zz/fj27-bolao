package com.felipe.odin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felipe.odin.models.Partida;
import com.felipe.odin.repository.PartidaRepository;

@Service
public class PartidaService {
	
	private PartidaRepository partidaRepository;
	
	public PartidaService(PartidaRepository partidaRepository) {
		this.partidaRepository = partidaRepository;
	}

	public List<Partida> listaPartidas(){
		return partidaRepository.findAll();
	}

}
