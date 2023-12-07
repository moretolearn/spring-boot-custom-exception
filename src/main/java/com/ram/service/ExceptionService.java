package com.ram.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Student;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@Service
public class ExceptionService {

	static List<Student> studentList = new ArrayList<>();

	@Autowired
	ObservationRegistry observationRegistry;

	public Student addStudent(Student student) {
		studentList.add(student);
		return Observation.createNotStarted("addStudent", observationRegistry).observe(() -> student);
	}

	public List<Student> getStudents() {
		return Observation.createNotStarted("getStudents", observationRegistry).observe(() -> studentList);
	}
}
