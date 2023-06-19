package com.apjl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apjl.dao.WorksDAO;
import com.apjl.model.Works;

@RestController
@RequestMapping("trabajos")
public class WorksRest {

	@Autowired
	private WorksDAO workDAO;
	
	@PostMapping("/nuevo")
	public void saveWork(@RequestBody Works work) {
		workDAO.save(work);
	}
	
	@GetMapping("/listar")
	public List<Works> listWorks(){
		return workDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteWork(@PathVariable("id") Integer id) {
		workDAO.deleteById(id);
	}
}