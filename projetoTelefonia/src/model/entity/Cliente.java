package model.entity;

import java.util.List;

public class Cliente {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private List<Telefone> telefones;
	private boolean ativo;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, Endereco endereco, List<Telefone> telefones, boolean ativo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
		this.ativo = ativo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", telefones=" + telefones + ", ativo=" + ativo + "]";
	}
}
