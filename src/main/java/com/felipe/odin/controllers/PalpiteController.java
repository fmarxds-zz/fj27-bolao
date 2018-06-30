package com.felipe.odin.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.odin.models.Palpite;
import com.felipe.odin.services.PalpiteService;

@RestController
@RequestMapping("/palpites")
public class PalpiteController {
	
	@Autowired private PalpiteService service;
	
	@PostMapping
	public ResponseEntity<Palpite> criaPalpite(@RequestBody Palpite palpite) throws URISyntaxException {
		Palpite palpiteCriado = service.criaPalpite(palpite);
		return ResponseEntity.created(new URI("/palpites/" + palpiteCriado.getId())).body(palpiteCriado);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Palpite> buscaPalpitePeloId(@PathVariable String id) {
		Palpite palpite = service.buscaPeloId(id);
		if (Objects.isNull(palpite)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(palpite);
		}
	}
	
	@PostMapping("/checaPalpites")
	public ResponseEntity<Palpite> checaPalpites() {
		service.checaPalpites();
		return ResponseEntity.accepted().build();
	}

}
