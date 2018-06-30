package com.felipe.odin.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.felipe.odin.models.Palpite;
import com.felipe.odin.models.Partida;
import com.felipe.odin.repository.PalpiteRepository;
import com.felipe.odin.repository.PartidaRepository;

@Component
public class ChecadorDoPalpite {
	
	@Autowired private PalpiteRepository palpiteRepository;
	@Autowired private PartidaRepository partidaRepository;
	
	@Scheduled(fixedRate = 120000)
	public void checaOsPalpites() {
		ArrayList<Palpite> palpitesCerteiros = new ArrayList<>();
		partidaRepository.findByStatus("completed")
			.forEach(partida -> {
				List<Palpite> palpites = palpiteRepository.findByCodigoPartida(partida.getCodigoDaFifa());
				palpites.forEach(palpite -> {
					boolean seGanhou = verificaSeGanhou(partida, palpite);
					if (seGanhou) {
						palpite.tonaPalpiteCerteiro();
						palpitesCerteiros.add(palpite);
					}
					palpite.palpiteVerificado();
				});
			});
		if (!palpitesCerteiros.isEmpty()) {
			palpiteRepository.save(palpitesCerteiros);
		}
	}
	
	public boolean verificaSeGanhou(Partida partida, Palpite palpite) {
		boolean resultadoDaCasa = partida.getMandante().getGols() == palpite.getMandante().getGols();
		boolean resultadoVisitante = partida.getVisitante().getGols() == palpite.getVisitante().getGols();
		return resultadoDaCasa && resultadoVisitante;
	}

}
