package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repository.StudentRepositorty;
import com.crud.service.StudentService;





@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	

	@Autowired
	private StudentRepositorty studentRepositorty;
	
	
	@PostMapping("/creat-student")
	public String createStudent(@RequestBody Student student) {
		
		studentService.addStudent(student);
	
		return "Student Saved Successfully";
	}
	
	// localhost:8080/read-student/29
	@GetMapping("/read-student/{id}")
	public Student readStudent(@PathVariable int id) {
		return studentRepositorty.findById(id).get();
		
	}
	
	
	@GetMapping("/readall-student")
	public List<Student> readAllStudent() {
		
		return studentRepositorty.findAll();
				
	}
	
	
	@PutMapping("/update-student")
	public String updateStudent(@RequestBody Student student ) {
		
		return studentService.updateStudent(student);
	
		
	}
	
	

	// localhost:8080/delete-student/29
	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		Optional<Student> student = studentRepositorty.findById(id);
		
		if(student.isPresent()) {
			studentRepositorty.deleteById(id);
			return "Student Deleted Successfully";
		}
		return "Student does not exist with this id";
		
	}	
	
	

}
