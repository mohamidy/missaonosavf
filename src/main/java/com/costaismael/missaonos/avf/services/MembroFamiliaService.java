package com.costaismael.missaonos.avf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.costaismael.missaonos.avf.domain.MembroFamilia;
import com.costaismael.missaonos.avf.repositories.MembroFamiliaRepository;
import com.costaismael.missaonos.avf.services.exceptions.DataIntegrityException;
import com.costaismael.missaonos.avf.services.exceptions.ObjectNotFoundException;

@Service
public class MembroFamiliaService {

	@Autowired
	private MembroFamiliaRepository repo;
	
	public MembroFamilia find(Integer id) {
		MembroFamilia obj = repo.findOne(id);
		
		if(obj==null) {
		   throw new ObjectNotFoundException("Objeto não encontrado id: "+id
				   +",Tipo: "+MembroFamilia.class.getName()); 	
		}		
		return obj;
	}
	
	public List<MembroFamilia> findAll() {
		return repo.findAll();
	}
	
	public List<MembroFamilia> findByFamiliaId(Integer familiaId) {
		List <MembroFamilia> obj = repo.findByFamiliaId(familiaId); 
		  return  obj;	
	}
	
	public MembroFamilia  findByMembroIdAndFamiliaId(Integer membroId, Integer familiaId) {		
		MembroFamilia obj = repo.findByMembroIdAndFamiliaId(membroId, familiaId);
		return obj;
	}
	
	public Page<MembroFamilia> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);		
	}
	
	public MembroFamilia insert(MembroFamilia obj) {

		MembroFamilia teste = findByMembroIdAndFamiliaId(obj.getMembro().getId(), obj.getFamilia().getId());
		
		if(teste!=null) {	
			throw new ObjectNotFoundException("Objeto já cadastrado Membro: "+obj.getMembro().getNome()
					   +",Tipo: "+MembroFamilia.class.getName()); 	
		}
		
		obj.setId(null);		
		return repo.save(obj);
	}
	
	public MembroFamilia update(MembroFamilia obj) {
	 
		find(obj.getId());
		return repo.save(obj);
	}	
	
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityException("Não é possível deletar MembroFamilia.");	
		}
	}	
}