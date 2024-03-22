package com.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	private Integer id;
	private String name;
	private String fathersName;
	private String MothersName;
	private String branch;
	private String session;
	

}
