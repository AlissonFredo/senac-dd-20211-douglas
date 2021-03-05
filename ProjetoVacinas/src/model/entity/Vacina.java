package model.entity;

import java.time.LocalDate;

public class Vacina {

		private String paisOrigem;
		private String estagioPesquisa;
		private LocalDate dataInicio;
		private String nomePesquisador;
		
		public Vacina() {
			super();
		}
		public Vacina(String paisOrigem, String estagioPesquisa, LocalDate dataInicio, String nomePesquisador) {
			super();
			this.paisOrigem = paisOrigem;
			this.estagioPesquisa = estagioPesquisa;
			this.dataInicio = dataInicio;
			this.nomePesquisador = nomePesquisador;
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
		public String getNomePesquisador() {
			return nomePesquisador;
		}
		public void setNomePesquisador(String nomePesquisador) {
			this.nomePesquisador = nomePesquisador;
		}
}
