package com.costaismael.missaonos.avf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.costaismael.missaonos.avf.domain.Usuario;
import com.costaismael.missaonos.avf.repositories.UsuarioRepository;
import com.costaismael.missaonos.avf.services.exceptions.DataIntegrityException;
import com.costaismael.missaonos.avf.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Usuario obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontrado id: "+id
				   +",Tipo: "+Usuario.class.getName()); 	
		}		
		return obj;
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);		
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		find(obj.getId());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não é possível deletar Usuario.");	
		}
	}	
}