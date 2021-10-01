package com.vti.dto;

import com.vti.entity.Candidate;

public class CandidateFormForCreating {

	private String fullName;
	private String phoneNumber;
	private short examSetID;
	private short status;
	private short creator;
	private String createDate;
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public void setStatus(short status) {
		this.status = status;
	}

	public short getCreator() {
		return creator;
	}

	public void setCreator(short creator) {
		this.creator = creator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public Candidate toEntity() {
		return new Candidate(fullName,phoneNumber,examSetID,status,creator,createDate);
	}

}
