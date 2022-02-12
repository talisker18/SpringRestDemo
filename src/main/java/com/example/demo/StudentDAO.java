package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //
public class StudentDAO{
	
	@Autowired //we do not have to implement the interface at class level!
	StudentRepo repo;
	
	public Student insert(Student s) {
		return repo.save(s);
	}
	
	public List<Student> insertMultiple(List<Student> list) {
		return repo.saveAll(list);
	}
	
	public List<Student> getAll(){
		return repo.findAll();
	}
	
	public Student getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted the id value: "+id;
	}
	
	public Student update(Student s) {
		Student existing = repo.findById(s.getSid()).orElse(null);
		existing.setName(s.getName());
		existing.setEmail(s.getEmail());
		return repo.save(existing);
	}
	
	public Student findByName(String name) {
		//add this method to interface StudentRepo
		return repo.findByName(name);
	}

}
