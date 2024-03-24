package com.crud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student")
public class Student {
	
	@Id
	private Integer id;
	private String name;
	private String fathersName;
	private String MothersName;
	private String branch;
	private String session;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return MothersName;
	}
	public void setMothersName(String mothersName) {
		MothersName = mothersName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fathersName=" + fathersName + ", MothersName=" + MothersName
				+ ", branch=" + branch + ", session=" + session + "]";
	}
	
	
	
	
	

}
