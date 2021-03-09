package model.entity;

import java.time.LocalDate;
import java.util.List;

public class Pessoa {

	private String nome;
	private String sexo;
	private String cpf;
	private LocalDate dataNacimento;
	private int tipo;
	private List<AplicacaoVacina> vacinacoes;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String sexo, String cpf, LocalDate dataNacimento, int tipo,
			List<AplicacaoVacina> vacinacoes) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNacimento = dataNacimento;
		this.tipo = tipo;
		this.vacinacoes = vacinacoes;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public List<AplicacaoVacina> getVacinacoes() {
		return vacinacoes;
	}

	public void setVacinacoes(List<AplicacaoVacina> vacinacoes) {
		this.vacinacoes = vacinacoes;
	}

}
