package com.costaismael.missaonos.avf.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Membro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="tipo_membro_id")
	private TipoMembro tipoMembro;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(mappedBy="membro")
	private List<MembroFamilia> membrosFamilias =  new ArrayList<>();
		
	public Membro() {
		
	}

	public Membro(Integer id, String nome,  Date dataNascimento, TipoMembro tipoMembro, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;		
		this.dataNascimento = dataNascimento;
		this.tipoMembro = tipoMembro;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoMembro getTipoMembro() {
		return tipoMembro;
	}

	public void setTipoMembro(TipoMembro tipoMembro) {
		this.tipoMembro = tipoMembro;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MembroFamilia> getMembrosFamilias() {
		return membrosFamilias;
	}

	public void setMembrosFamilias(List<MembroFamilia> membrosFamilias) {
		this.membrosFamilias = membrosFamilias;
	}

	@Override
	public String toString() {
		return "Membro [nome=" + nome + "]";
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
