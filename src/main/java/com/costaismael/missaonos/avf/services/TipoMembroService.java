package com.costaismael.missaonos.avf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.costaismael.missaonos.avf.domain.TipoMembro;
import com.costaismael.missaonos.avf.repositories.TipoMembroRepository;
import com.costaismael.missaonos.avf.services.exceptions.DataIntegrityException;
import com.costaismael.missaonos.avf.services.exceptions.ObjectNotFoundException;

@Service
public class TipoMembroService {

	@Autowired
	private TipoMembroRepository repo;
	
	public TipoMembro find(Integer id) {
		TipoMembro obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontado id: "+id
				   +",Tipo: "+TipoMembro.class.getName()); 	
		}		
		return obj;
	}
	
	public List<TipoMembro> findAll() {
		return repo.findAll();
	}
	
	public Page<TipoMembro> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);		
	}
	
	public TipoMembro insert(TipoMembro obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoMembro update(TipoMembro obj) {
		find(obj.getId());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não é possível deletar TipoMembro que possui produtos.");	
		}
	}	
}