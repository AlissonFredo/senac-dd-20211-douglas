package model.entity;

import java.util.List;

public class Cliente {

	private String nome;
	private String cpg;
	private Endereco endereco;
	private List<Telefone> telefones;
	private boolean ativo;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpg, Endereco endereco, List<Telefone> telefones, boolean ativo) {
		super();
		this.nome = nome;
		this.cpg = cpg;
		this.endereco = endereco;
		this.telefones = telefones;
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpg() {
		return cpg;
	}

	public void setCpg(String cpg) {
		this.cpg = cpg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
