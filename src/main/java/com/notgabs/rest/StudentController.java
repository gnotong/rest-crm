package com.notgabs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.notgabs.entity.Student;
import com.notgabs.exception.StudentNotFoundException;

@RestController
public class StudentController {
	List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
		 
		students.add(new Student("John", "Doe", 25));
		students.add(new Student("Gabs", "Doe", 36));
		students.add(new Student("Hendy", "Duna", 6));
	}
	
	@GetMapping("/students")
	public List<Student> list() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student one(@PathVariable("id") int id) {
		if ((id-1) < 0 || id-1 >= students.size()) {
			throw new StudentNotFoundException("Student id not found - " + id);
		}
		
		return students.get(id-1);
	}
}
