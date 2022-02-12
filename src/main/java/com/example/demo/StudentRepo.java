package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer>{ //JpaRepository contains all the CRUD methods

	//not defined in JpaRepository. so do it yourself
	//jpql style
	//@Query("select stud from Student stud where stud.name=?1") //from Student = class, then followed by any alias...then ?1 as first param
	
	//native style
	@Query(value = "SELECT * FROM student WHERE name =?1", nativeQuery = true)
	Student findByName(String name);
	
	
	/**
	 * jpql:
	 * 
	 * UserEntity, in this case Student – is the name of the Entity class which you can find below in this tutorial. 
	 * When we create SQL queries with JPQL, we query not the database table by its name but by an Entity class name. 
	 * This is a very important difference between JPQL SQL Queries and the Native SQL queries. When creating a Native SQL 
	 * query we would use a database name in the query but in the JPQL, we need to use an Entity class name and not the database table name.
	 * 
	 * 
	 * */
}
