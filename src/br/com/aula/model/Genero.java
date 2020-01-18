package br.com.aula.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GENERO")
public class Genero implements Serializable {

	private static final long serialVersionUID = 2183975558585684316L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricaoGenero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoGenero() {
		return descricaoGenero;
	}

	public void setDescricaoGenero(String descricaoGenero) {
		this.descricaoGenero = descricaoGenero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoGenero == null) ? 0 : descricaoGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (descricaoGenero == null) {
			if (other.descricaoGenero != null)
				return false;
		} else if (!descricaoGenero.equals(other.descricaoGenero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
