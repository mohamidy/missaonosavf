package com.costaismael.missaonos.avf.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.costaismael.missaonos.avf.domain.Familia;
import com.costaismael.missaonos.avf.services.FamiliaService;

@RestController
@RequestMapping(value="/familias")
public class FamiliaResource {
	
	@Autowired
	private FamiliaService service;
	
	//find
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Familia> find(@PathVariable Integer id) {			
		Familia obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	//findAll
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Familia>> findAll() {			
		List<Familia> list = service.findAll();		
		return ResponseEntity.ok().body(list);		
	}
	
	//findPage
		@RequestMapping(value="/page",method = RequestMethod.GET)
		public ResponseEntity<Page<Familia>> findPage(
				@RequestParam(value="page",defaultValue = "0") Integer page,
				@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage, 
				@RequestParam(value="orderBy",defaultValue = "id") String orderBy, 
				@RequestParam(value="direction",defaultValue = "ASC") String direction) {			
			//Converte uma lista para outra lista
			Page<Familia> list = service.findPage(page, linesPerPage, orderBy, direction);			
			return ResponseEntity.ok().body(list);		
		}
	//insert
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Familia obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//update
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Familia obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}	
	
	//delete
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {			
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}	
}
