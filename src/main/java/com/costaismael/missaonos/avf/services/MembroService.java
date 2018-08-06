package com.costaismael.missaonos.avf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.costaismael.missaonos.avf.domain.Membro;
import com.costaismael.missaonos.avf.repositories.MembroRepository;
import com.costaismael.missaonos.avf.services.exceptions.DataIntegrityException;
import com.costaismael.missaonos.avf.services.exceptions.ObjectNotFoundException;

@Service
public class MembroService {

	@Autowired
	private MembroRepository repo;
	
	public Membro find(Integer id) {
		Membro obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontrado id: "+id
				   +",Tipo: "+Membro.class.getName()); 	
		}		
		return obj;
	}
	
	public List<Membro> findAll() {
		return repo.findAll();
	}
	
	public Page<Membro> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);		
	}
	
	public Membro insert(Membro obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Membro update(Membro obj) {
		find(obj.getId());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não é possível deletar Membro.");	
		}
	}	
}