package com.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.repository.StudentRepositorty;
import com.crud.service.StudentService;




@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepositorty studentRepositorty;
	
	
	
	
	

}
