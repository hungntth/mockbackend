package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Short>, JpaSpecificationExecutor<Candidate>{
	public Candidate findByFullName(String fullName);
	public boolean existsByPhoneNumber(String phoneNumber);
	public void deleteById(Short id);
	
}
