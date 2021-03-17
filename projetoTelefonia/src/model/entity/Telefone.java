package model.entity;

public class Telefone {

	private Integer id;
	private String codigoInternacional;
	private String ddd;
	private String numero;
	private Cliente dono;
	private boolean movel;
	private boolean ativo;

	public Telefone() {
		super();
	}

	public Telefone(Integer id, String codigoInternacional, String ddd, String numero, Cliente dono, boolean movel,
			boolean ativo) {
		super();
		this.id = id;
		this.codigoInternacional = codigoInternacional;
		this.ddd = ddd;
		this.numero = numero;
		this.dono = dono;
		this.movel = movel;
		this.ativo = ativo;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", codigoInternacional=" + codigoInternacional + ", ddd=" + ddd + ", numero="
				+ numero + ", dono=" + dono + ", movel=" + movel + ", ativo=" + ativo + "]";
	}
}
