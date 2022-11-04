package com.ty.schoolbootapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			studentRepository.deleteById(id);
			return id + " deleted";
		} else {
			return id + " Not Found";
		}

	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	

}
