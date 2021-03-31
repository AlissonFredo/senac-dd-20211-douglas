package model.vo;

import java.time.LocalDate;

public class AplicacaoVacinaVO {

	private int idAplicacaoVacina;
	private VacinaVO vacina;
	private LocalDate dataAplicacao;
	private int notaVacina;

	public AplicacaoVacinaVO() {
		super();
	}

	public AplicacaoVacinaVO(VacinaVO vacina, LocalDate dataAplicacao, int notaVacina) {
		super();
		this.vacina = vacina;
		this.dataAplicacao = dataAplicacao;
		this.notaVacina = notaVacina;
	}

	public VacinaVO getVacina() {
		return vacina;
	}

	public void setVacina(VacinaVO vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public int getNotaVacina() {
		return notaVacina;
	}

	public void setNotaVacina(int notaVacina) {
		this.notaVacina = notaVacina;
	}

	public int getIdAplicacaoVacina() {
		return idAplicacaoVacina;
	}

	public void setIdAplicacaoVacina(int idAplicacaoVacina) {
		this.idAplicacaoVacina = idAplicacaoVacina;
	}
}
