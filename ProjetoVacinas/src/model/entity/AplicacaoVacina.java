package model.entity;

import java.util.Date;

public class AplicacaoVacina {

	private Vacina vacina;
	private Date dataAplicacao;
	private int notaVacina;

	public AplicacaoVacina() {
		super();
	}

	public AplicacaoVacina(Vacina vacina, Date dataAplicacao, int notaVacina) {
		super();
		this.vacina = vacina;
		this.dataAplicacao = dataAplicacao;
		this.notaVacina = notaVacina;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public int getNotaVacina() {
		return notaVacina;
	}

	public void setNotaVacina(int notaVacina) {
		this.notaVacina = notaVacina;
	}

}
