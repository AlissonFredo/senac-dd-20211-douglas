package model.vo;

import java.time.LocalDate;
import java.util.List;

public class PessoaVO {

	private Integer idPessoa;
	private String nome;
	private String sexo;
	private String cpf;
	private LocalDate dataNacimento;
	private int tipo;
	private List<AplicacaoVacinaVO> vacinacoes;

	public PessoaVO() {
		super();
	}

	public PessoaVO(String nome, String sexo, String cpf, LocalDate dataNacimento, int tipo,
			List<AplicacaoVacinaVO> vacinacoes) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNacimento = dataNacimento;
		this.tipo = tipo;
		this.vacinacoes = vacinacoes;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
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

	public List<AplicacaoVacinaVO> getVacinacoes() {
		return vacinacoes;
	}

	public void setVacinacoes(List<AplicacaoVacinaVO> vacinacoes) {
		this.vacinacoes = vacinacoes;
	}

	@Override
	public String toString() {
		return "PessoaVO [idPessoa=" + idPessoa + ", nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf
				+ ", dataNacimento=" + dataNacimento + ", tipo=" + tipo + ", vacinacoes=" + vacinacoes + "]";
	}

}
