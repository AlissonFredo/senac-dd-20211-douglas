package model.entity;

public class Telefone {

	private String codigoInternacional;
	private String ddd;
	private String numero;
	private boolean movel;
	private boolean ativo;

	public Telefone() {
		super();
	}

	public Telefone(String codigoInternacional, String ddd, String numero, boolean movel, boolean ativo) {
		super();
		this.codigoInternacional = codigoInternacional;
		this.ddd = ddd;
		this.numero = numero;
		this.movel = movel;
		this.ativo = ativo;
	}

	public String getCodigoInternacional() {
		return codigoInternacional;
	}

	public void setCodigoInternacional(String codigoInternacional) {
		this.codigoInternacional = codigoInternacional;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isMovel() {
		return movel;
	}

	public void setMovel(boolean movel) {
		this.movel = movel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
