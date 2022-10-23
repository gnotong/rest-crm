package com.notgabs.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notgabs.entity.Student;

@RestController
public class StudentController {
	
	@GetMapping("/students")
	public List<Student> list() {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("John", "Doe", 25));
		
		return students;
	}
}
