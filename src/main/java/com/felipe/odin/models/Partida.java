package com.felipe.odin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="partidas") //Habilita o mapeamento da classe pelo MongoDB
public class Partida {
	
	@Id
	private String id;
	private String estadio;
	private String codigoVencedor;
	private Long codigoDaFifa;
	private Selecao mandante;
	private Selecao visitante;
	private String status;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getCodigoVencedor() {
		return codigoVencedor;
	}
	public void setCodigoVencedor(String codigoVencedor) {
		this.codigoVencedor = codigoVencedor;
	}
	public Long getCodigoDaFifa() {
		return codigoDaFifa;
	}
	public void setCodigoDaFifa(Long codigoDaFifa) {
		this.codigoDaFifa = codigoDaFifa;
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

}
