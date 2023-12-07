package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.Student;
import com.ram.service.ExceptionService;

@RestController
@RequestMapping("/student")
public class ExceptionController {
	
	@Autowired
	ExceptionService exceptionService;

//	@GetMapping
//	public String getData() {
//		if(true) {
//			//throw new UserNotFoundException("good bye");
//			throw new RuntimeException("Data Not Found");
//		}
//		return "hi"; 
//	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return exceptionService.addStudent(student);
	}
	
	@GetMapping
	public List<Student> getStudents(){
		return exceptionService.getStudents();
	}
}
