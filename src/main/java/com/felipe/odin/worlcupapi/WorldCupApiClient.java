package com.felipe.odin.worlcupapi;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.felipe.odin.worlcupapi.models.Match;

@FeignClient(name="world-cup", url="${worldcup.api}")
public interface WorldCupApiClient {

	@GetMapping(value="/matches")
	List<Match> buscaPorPartidasNaApi(); 
	
}
