package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NomeExercicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeExercicio() {

	}

	public NomeExercicio(Long id, String nome, GrupoMuscular gMusc) {
		super();
		this.id = id;
		this.nome = nome;
		this.gMusc = gMusc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private GrupoMuscular gMusc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrupoMuscular getgMusc() {
		return gMusc;
	}

	public void setgMusc(GrupoMuscular gMusc) {
		this.gMusc = gMusc;
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
		NomeExercicio other = (NomeExercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
