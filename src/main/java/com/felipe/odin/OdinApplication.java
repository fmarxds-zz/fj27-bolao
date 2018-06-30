package com.felipe.odin;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.felipe.odin.models.Partida;
import com.felipe.odin.repository.PartidaRepository;
import com.felipe.odin.worlcupapi.WorldCupApiClient;
import com.felipe.odin.worlcupapi.models.Match;

@SpringBootApplication
@EnableFeignClients
public class OdinApplication {
	
	@Autowired private WorldCupApiClient client;
	@Autowired private PartidaRepository partidaRepository;

	public static void main(String[] args) {
		SpringApplication.run(OdinApplication.class, args);
	}
	
	@PostConstruct
	public void populateDatabase() {
		if (partidaRepository.count() <= 0) {
			List <Partida> partidas = client.buscaPorPartidasNaApi().stream().map(Match::toDomain).collect(Collectors.toList());
			partidaRepository.save(partidas);
		}
	}
}
