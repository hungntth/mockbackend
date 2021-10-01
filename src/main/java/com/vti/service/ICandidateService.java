package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.filter.CandidateFilter;
import com.vti.entity.Candidate;
import com.vti.dto.CandidateFormForCreating;
import com.vti.dto.CandidateFormForUpdating;

public interface ICandidateService {
	
	Page<Candidate> getAllCandidates(Pageable pageable, CandidateFilter fillter, String search);
	
	boolean isCandidateExistsByPhone(String phoneNumber);

	void createCandidate(CandidateFormForCreating form);
	
	Candidate getCandidateByID(short id);

	void updateCandidate(short id, CandidateFormForUpdating form);

	void deleteCandidate(short id);

	


}
