package com.felipe.odin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipe.odin.models.Palpite;

@Repository
public interface PalpiteRepository extends MongoRepository<Palpite, String> {
	
	List<Palpite> findByCodigoPartida(Long codigoPartida);

}
