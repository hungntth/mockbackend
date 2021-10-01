package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vti.dto.filter.CandidateFilter;
import com.vti.entity.Candidate;
import com.vti.service.ICandidateService;
import com.vti.dto.CandidateFormForCreating;
import com.vti.dto.CandidateFormForUpdating;



@RestController
@RequestMapping(value = "api/v1/candidates")
public class CandidateController {
	@Autowired
	private ICandidateService service;

	@GetMapping()
	public ResponseEntity<?> getAllCandidates(
			Pageable pageable, 
			CandidateFilter filter,
			@RequestParam(required = false) String search) {
		Page<Candidate> entities = service.getAllCandidates(pageable, filter, search);
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}
	@GetMapping(value = "/{candidateID}")
	public ResponseEntity<?> getCandidateByID(@PathVariable(name = "candidateID") short id) {
		return new ResponseEntity<>(service.getCandidateByID(id), HttpStatus.OK);
	}

	@PutMapping(value = "/{candidateID}")
	public ResponseEntity<?> updateCandidate(@PathVariable(name = "candidateID") short id, @RequestBody CandidateFormForUpdating form) {
		service.updateCandidate(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}
	@GetMapping(value = "/phoneNumber/{phoneNumber}")
	public ResponseEntity<?> existsCandidateByPhone(@PathVariable(name = "phoneNumber") String phoneNumber) {
		return new ResponseEntity<>(service.isCandidateExistsByPhone(phoneNumber), HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<?> createCandidate(@RequestBody CandidateFormForCreating form) {
		service.createCandidate(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}
	@DeleteMapping(value = "/{candidateID}")
	public ResponseEntity<?> deleteCandidate(@PathVariable(name = "candidateID") short id) {
		service.deleteCandidate(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	
	
}
