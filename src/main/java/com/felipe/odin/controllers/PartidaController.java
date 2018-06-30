package com.felipe.odin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.odin.models.Partida;
import com.felipe.odin.services.PartidaService;

@RestController
@RequestMapping("partidas")
public class PartidaController {
	
	@Autowired private PartidaService service;
	
	@GetMapping
	public ResponseEntity<List<Partida>> buscaPartidas(){
		return ResponseEntity.ok(service.listaPartidas());
	}

}
