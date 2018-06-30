package com.felipe.odin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.odin.models.Palpite;
import com.felipe.odin.repository.PalpiteRepository;

@Service
public class PalpiteService {
	
	@Autowired private PalpiteRepository palpiteRepository;
	@Autowired private ChecadorDoPalpite checadorDoPalpite;
	
	public Palpite criaPalpite(Palpite palpite) {
		return palpiteRepository.save(palpite);
	}

	public void checaPalpites() {
		checadorDoPalpite.checaOsPalpites();
	}

	public Palpite buscaPeloId(String id) {
		return palpiteRepository.findOne(id);
	}

}
