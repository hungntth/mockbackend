package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`Candidate`")
public class Candidate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "candidateID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short candidateID;
	
	@Column(name = "fullName", length = 100, nullable = false, unique=true)
	private String fullName;
	
	@Column(name = "phoneNumber", length = 20, nullable = false, unique=true)
	private String phoneNumber;
	
	@Column(name = "examSetID", length = 50, nullable = false, unique=true)
	private short examSetID;
	
	@Column(name= "status", length = 50, nullable = false, unique=true)
	private short status;
	
	
	@Column(name= "creator", length = 50, nullable = false, unique=true)
	private short creator;
	
	@Column(name= "createDate", length = 50, nullable = false, unique=true)
	private String createDate;

	public Candidate() {
		super();
	}
	public Candidate(String fullName, String phoneNumber, short examSetID, short status, short creator, String createDate) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.examSetID = examSetID;
		this.status = status;
		this.creator = creator;
		this.createDate = createDate;
	}

	
	public String getFullName() {
		return fullName;
	}
	
	public short getCandidateID() {
		return candidateID;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}


	public short getExamSetID() {
		return examSetID;
	}

	public void setExamSetID(short examSetID) {
		this.examSetID = examSetID;
	}

	public short getStatus() {
		return status;
	}


	public short getCreator() {
		return creator;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
		
	}
	
}
