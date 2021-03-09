package model.entity;

import java.time.LocalDate;

public class Vacina {

	private String nomeVacina;
	private String paisOrigem;
	private String estagioPesquisa;
	private LocalDate dataInicio;
	private Pessoa nomePesquisador;
	private int fase;
	private int quantidadeDoses;

	public Vacina() {
		super();
	}

	public Vacina(String nomeVacina, String paisOrigem, String estagioPesquisa, LocalDate dataInicio,
			Pessoa nomePesquisador, int fase, int quantidadeDoses) {
		super();
		this.nomeVacina = nomeVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dataInicio = dataInicio;
		this.nomePesquisador = nomePesquisador;
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

	public Pessoa getNomePesquisador() {
		return nomePesquisador;
	}

	public void setNomePesquisador(Pessoa nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
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
}
