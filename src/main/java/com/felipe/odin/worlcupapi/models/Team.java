package com.felipe.odin.worlcupapi.models;

import com.felipe.odin.models.Selecao;

public class Team {
	
	private String country;
	private String code;
	private Integer goals;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	
	public Selecao toDomain() {
		Selecao selecao = new Selecao();
		selecao.setNome(country);
		selecao.setSigla(code);
		selecao.setGols(goals);
		return selecao;
	}
	
}
