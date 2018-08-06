package com.costaismael.missaonos.avf.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MembroFamilia implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  	private Integer id;
	
    @ManyToOne
	@JoinColumn(name="membro_id")
	private Membro membro;
	
    @ManyToOne
	@JoinColumn(name="familia_id")
	private Familia familia;
    
	private Integer familiaPrincipal;
	
	public MembroFamilia() {
		
	}

	public MembroFamilia(Integer id, Membro membro, Familia familia, Integer familiaPrincipal) {
		super();
		this.id = id;
		this.membro = membro;
		this.familia = familia;
		this.familiaPrincipal = familiaPrincipal;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Integer getFamiliaPrincipal() {
		return familiaPrincipal;
	}

	public void setFamiliaPrincipal(Integer familiaPrincipal) {
		this.familiaPrincipal = familiaPrincipal;
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
		MembroFamilia other = (MembroFamilia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
