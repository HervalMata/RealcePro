package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Exercicio implements Serializable {

	/**
	 * Autor Yuri Morais
	 */
	private static final long serialVersionUID = 1L;

	public Exercicio() {

	}

	public Exercicio(Long id, String periodizacao, Serie serie, NomeExercicio nomeExerc, SerieRepeti serieRepe,
			int peso, TipoCarga tipoCarga, Metodo metodo, Usuario usuario) {
		super();
		this.periodizacao = periodizacao;
		this.serie = serie;
		this.nomeExerc = nomeExerc;
		this.serieRepe = serieRepe;
		this.peso = peso;
		this.tipoCarga = tipoCarga;
		this.metodo = metodo;
		this.usuario = usuario;
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String periodizacao;

	@Enumerated(EnumType.STRING)
	private Serie serie;

	@OneToOne
	private NomeExercicio nomeExerc = new NomeExercicio();

	@Enumerated(EnumType.STRING)
	private SerieRepeti serieRepe;

	private int peso;

	@Enumerated(EnumType.STRING)
	private TipoCarga tipoCarga;

	@Enumerated(EnumType.STRING)
	private Metodo metodo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario = new Usuario();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodizacao() {
		return periodizacao;
	}

	public void setPeriodizacao(String periodizacao) {
		this.periodizacao = periodizacao;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public NomeExercicio getNomeExerc() {
		return nomeExerc;
	}

	public void setNomeExerc(NomeExercicio nomeExerc) {
		this.nomeExerc = nomeExerc;
	}

	public SerieRepeti getSerieRepe() {
		return serieRepe;
	}

	public void setSerieRepe(SerieRepeti serieRepe) {
		this.serieRepe = serieRepe;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public TipoCarga getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(TipoCarga tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercicio other = (Exercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
