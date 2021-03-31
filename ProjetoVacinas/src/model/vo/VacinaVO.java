package model.vo;

import java.time.LocalDate;

public class VacinaVO {

	private Integer idVacina;
	private String nomeVacina;
	private String paisOrigem;
	private String estagioPesquisa;
	private LocalDate dataInicio;
	private PessoaVO pesquisador;
	private int fase;
	private int quantidadeDoses;

	public VacinaVO() {
		super();
	}

	public VacinaVO(String nomeVacina, String paisOrigem, String estagioPesquisa, LocalDate dataInicio,
			PessoaVO pesquisador, int fase, int quantidadeDoses) {
		super();
		this.nomeVacina = nomeVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicio = dataInicio;
		this.pesquisador = pesquisador;
		this.fase = fase;
		this.quantidadeDoses = quantidadeDoses;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public int getQuantidadeDoses() {
		return quantidadeDoses;
	}

	public void setQuantidadeDoses(int quantidadeDoses) {
		this.quantidadeDoses = quantidadeDoses;
	}

	public Integer getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(Integer idVacina) {
		this.idVacina = idVacina;
	}

	public PessoaVO getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(PessoaVO pesquisador) {
		this.pesquisador = pesquisador;
	}
}
