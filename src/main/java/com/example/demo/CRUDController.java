package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {
	
	@Autowired
	StudentDAO dao;
	
	@PostMapping("insert")
	public Student insert(@RequestBody Student s) {
		return dao.insert(s);
	}
	
	@PostMapping("insertMultiple")
	public List<Student> insertMultiple(@RequestBody List<Student> list) {
		return dao.insertMultiple(list);
	}
	
	@GetMapping("getAll")
	public List<Student> getAll() {
		
		return dao.getAll();
	}
	
	@GetMapping("getById/{id}")
	public Student getById(@PathVariable ("id") int id) {
		
		return dao.getById(id);
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable ("id") int id) {
		dao.deleteById(id);
		return "student deleted with id: "+id;
	}
	
	@PutMapping("update")
	public Student update(@RequestBody Student s) {
		return dao.update(s); 
	}
	
	@GetMapping("getByName/{name}")
	public Student getByName(@PathVariable("name") String name) {
		return dao.findByName(name);
	}

}
