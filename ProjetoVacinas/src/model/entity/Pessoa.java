package model.entity;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private String sexo;
	private String cpf;
	private LocalDate dataNacimento;
	private Vacina vacina;
	private int reacaoVacina;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String sexo, String cpf, LocalDate dataNacimento, Vacina vacina, int reacaoVacina) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNacimento = dataNacimento;
		this.vacina = vacina;
		this.reacaoVacina = reacaoVacina;
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

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public int getReacaoVacina() {
		return reacaoVacina;
	}

	public void setReacaoVacina(int reacaoVacina) {
		this.reacaoVacina = reacaoVacina;
	}
}
