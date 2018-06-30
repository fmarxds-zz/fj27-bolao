package com.felipe.odin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="palpites")
public class Palpite {
	
	@Id
	private String id;
	private Selecao mandante;
	private Selecao visitante;
	private Long codigoPartida;
	private String palpiteiro;
	private boolean vencedor;
	private boolean computado;
	
	public void palpiteVerificado() {
		this.computado = true;
	}
	
	public void tonaPalpiteCerteiro() {
		this.vencedor = true;
	}
	
	public boolean getVencedor() {
		return this.vencedor;
	}
	
	public boolean getComputado() {
		return this.computado;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Selecao getMandante() {
		return mandante;
	}
	public void setMandante(Selecao mandante) {
		this.mandante = mandante;
	}
	public Selecao getVisitante() {
		return visitante;
	}
	public void setVisitante(Selecao visitante) {
		this.visitante = visitante;
	}
	public Long getCodigoPartida() {
		return codigoPartida;
	}
	public void setCodigoPartida(Long codigoPartida) {
		this.codigoPartida = codigoPartida;
	}
	public String getPalpiteiro() {
		return palpiteiro;
	}
	public void setPalpiteiro(String palpiteiro) {
		this.palpiteiro = palpiteiro;
	}
}
