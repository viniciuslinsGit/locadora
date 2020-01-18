package br.com.aula.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_FILME")
public class Filme implements Serializable {

	private static final long serialVersionUID = -6096174077164464186L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	private int duracao;

	@Temporal(TemporalType.DATE)
	private Date datadLancamento;
	private String faixaEtaria;
	private float nota;
	private String comentario;

	@ManyToMany
	@JoinTable(name = "TB_FILME_GENERO",
	joinColumns = @JoinColumn(name="ID_FILME", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="ID_GENERO", referencedColumnName = "id"))
	private List<Genero> generos;

	@ManyToMany
	@JoinTable(name = "TB_FILME_ATOR",
	joinColumns = @JoinColumn(name="ID_FILME", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="ID_ATOR", referencedColumnName = "id"))
	private List<Ator> atores;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getDatadLancamento() {
		return datadLancamento;
	}
	public void setDatadLancamento(Date datadLancamento) {
		this.datadLancamento = datadLancamento;
	}
	public String getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public List<Ator> getAtores() {
		return atores;
	}
	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atores == null) ? 0 : atores.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((datadLancamento == null) ? 0 : datadLancamento.hashCode());
		result = prime * result + duracao;
		result = prime * result + ((faixaEtaria == null) ? 0 : faixaEtaria.hashCode());
		result = prime * result + ((generos == null) ? 0 : generos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(nota);
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Filme other = (Filme) obj;
		if (atores == null) {
			if (other.atores != null)
				return false;
		} else if (!atores.equals(other.atores))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (datadLancamento == null) {
			if (other.datadLancamento != null)
				return false;
		} else if (!datadLancamento.equals(other.datadLancamento))
			return false;
		if (duracao != other.duracao)
			return false;
		if (faixaEtaria == null) {
			if (other.faixaEtaria != null)
				return false;
		} else if (!faixaEtaria.equals(other.faixaEtaria))
			return false;
		if (generos == null) {
			if (other.generos != null)
				return false;
		} else if (!generos.equals(other.generos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(nota) != Float.floatToIntBits(other.nota))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
}
