package model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco {

	private String cep;
	private String rua;
	private Integer numero;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cid cidade = new Cid();

	
	public Cid getCidade() {
		return cidade;
	}

	public void setCidade(Cid cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
