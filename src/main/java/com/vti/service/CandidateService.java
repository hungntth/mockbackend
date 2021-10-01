package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.dto.filter.CandidateFilter;
import com.vti.dto.CandidateFormForCreating;
import com.vti.dto.CandidateFormForUpdating;
import com.vti.entity.Candidate;
import com.vti.repository.CandidateRepository;
import com.vti.specification.CandidateSpecificationBuilder;


@Service
public class CandidateService implements ICandidateService {

	@Autowired
	private CandidateRepository repository;

	public Page<Candidate> getAllCandidates(Pageable pageable, CandidateFilter filter, String search) {

		CandidateSpecificationBuilder specification = new CandidateSpecificationBuilder(filter, search);

		return repository.findAll(specification.build(), pageable);
	}
	public Candidate getCandidateByID(short id) {
		return repository.findById(id).get();
	}

	public void updateCandidate(short id, CandidateFormForUpdating form) {
		Candidate entity = repository.findById(id).get();
		entity.setFullName(form.getFullName());
		entity.setPhoneNumber(form.getPhoneNumber());
		repository.save(entity);
	}
	
	public boolean isCandidateExistsByPhone(String phoneNumber) {
		return repository.existsByPhoneNumber(phoneNumber);
	}
	
	public void createCandidate(CandidateFormForCreating form) {
		// TODO Auto-generated method stub
		repository.save(form.toEntity());
	}
	public void deleteCandidate(short id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}


}
