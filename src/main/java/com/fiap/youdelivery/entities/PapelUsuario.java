package com.fiap.youdelivery.entities;

public enum PapelUsuario {
	
	ADMIN("admin"),
	USER("user");
	
	private String papel;

	PapelUsuario(String papel) {
		this.papel = papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

}
