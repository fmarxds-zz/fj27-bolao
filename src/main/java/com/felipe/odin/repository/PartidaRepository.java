package com.felipe.odin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipe.odin.models.Partida;

public interface PartidaRepository extends MongoRepository<Partida, String> {
	
	List<Partida> findByStatus(String status);

}
