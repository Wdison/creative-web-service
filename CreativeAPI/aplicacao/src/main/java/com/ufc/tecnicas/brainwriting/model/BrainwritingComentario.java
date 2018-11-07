package com.ufc.tecnicas.brainwriting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.tecnicas.model.Pessoa;

@Entity
@Table(name = "brainwriting_comentario")
public class BrainwritingComentario {

	@Id
	@GeneratedValue
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String texto;

//	@JsonSerialize(using = CalendarSerialize.class)
//	@JsonDeserialize(using = CalendarDeserialize.class)
        @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Calendar data;

	@ManyToOne
	private Pessoa autor;

	@ManyToOne
	private BrainwritingIdeia ideia;

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	@JsonView(BrainwritingViews.IdeiaDetalhes.class)
	public PessoaBrainwriting autor() {
		return new PessoaBrainwriting(autor);
	}

	@JsonIgnore
	public BrainwritingIdeia getIdeia() {
		return ideia;
	}

	public void setIdeia(BrainwritingIdeia ideia) {
		this.ideia = ideia;
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
		BrainwritingComentario other = (BrainwritingComentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
