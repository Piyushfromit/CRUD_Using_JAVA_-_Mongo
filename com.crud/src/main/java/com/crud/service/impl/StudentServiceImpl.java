package com.crud.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repository.StudentRepositorty;
import com.crud.service.StudentService;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;



@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepositorty studentRepositorty;
	
	@Autowired
    private MongoOperations mongoOperations;
	
	
	@Override
	public Student addStudent(Student student) {
		 int id = generateUniqueIntegerId();
		student.setId(id);
		return studentRepositorty.save(student);
		
	}
	
	
	@Override
	public String updateStudent(Student student) {
		
		//    get the existing student FromBuilder DB
		Optional<Student> existingStudent = studentRepositorty.findById(student.getId());
		if(existingStudent.isPresent()) {
			Student stu =existingStudent.get();
			stu.setName(student.getName());
			stu.setFathersName(student.getFathersName());
			stu.setMothersName(student.getMothersName());
			stu.setBranch(student.getBranch());
			stu.setSession(student.getSession());
			studentRepositorty.save(stu);
			return "Student Updated Successfully";
		
		}
		
		return "Student does not exist with this id";
		
	}
	
	
	
	private int generateUniqueIntegerId() {
        // Query to find the maximum existing ID
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "id"));
        query.limit(1);
        Student lastStudent = mongoOperations.findOne(query, Student.class);
        int id = 1; // Default ID if no documents exist yet
        if (lastStudent != null) {
            id = lastStudent.getId() + 1; // Increment the last ID
        }
        return id;
    }
	

}
