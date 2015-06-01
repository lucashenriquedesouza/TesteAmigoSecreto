package com.teste.model;

public class AmigoModel {

	private int Id;
	private String Nome;
	private String Email;
	private AmigoModel Secreto;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public AmigoModel getSecreto() {
		return Secreto;
	}
	public void setSecreto(AmigoModel secreto) {
		Secreto = secreto;
	}
	
}
