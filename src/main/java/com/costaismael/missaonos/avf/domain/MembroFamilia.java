package com.costaismael.missaonos.avf.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MembroFamilia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MembroFamiliaPk id = new MembroFamiliaPk();
	
	private Integer familiaPrincipal;
	
	public MembroFamilia() {
		
	}

	public MembroFamilia(Membro membro, Familia familia, Integer familiaPrincipal) {
		super();
		this.id.setFamilia(familia);
		this.id.setMembro(membro);
		this.familiaPrincipal = familiaPrincipal;
	}

	public Membro getMembro() {
		return id.getMembro();
	}
	
	public Familia getFamilia() {
		return id.getFamilia();
	}
	
	public MembroFamiliaPk getId() {
		return id;
	}

	public void setMembro(Membro membro) {
		this.id.setMembro(membro); 
	}
	
	public void setFamilia(Familia familia) {
		this.id.setFamilia(familia); 
	}
	
	public void setId(MembroFamiliaPk id) {
		this.id = id;
	}

	public Integer getFamiliaPrincipal() {
		return familiaPrincipal;
	}

	public void setFamiliaPrincipal(Integer familiaPrincipal) {
		this.familiaPrincipal = familiaPrincipal;
	}
	
	
}
