package model.entity;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private String sexo;
	private String cpf;
	private LocalDate dataNacimento;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, String sexo, String cpf, LocalDate dataNacimento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNacimento = dataNacimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNacimento() {
		return dataNacimento;
	}
	public void setDataNacimento(LocalDate dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
}
