package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.dto.filter.CandidateFilter;
import com.vti.entity.Candidate;


public class CandidateSpecificationBuilder {
	private CandidateFilter filter;
	private String search;
	
	
public CandidateSpecificationBuilder(CandidateFilter filter, String search) {
		super();
		this.filter = filter;
		this.search = search;
	}


@SuppressWarnings("deprecation")
public Specification<Candidate> build(){
	SearchCriteria seachCriteria = new SearchCriteria("fullName", "Like", search);
	SearchCriteria minCreatorCriteria = new SearchCriteria("creator", ">=", filter.getMinCreator());
	SearchCriteria maxCreatorCriteria = new SearchCriteria("creator", "<=", filter.getMaxCreator());

	Specification<Candidate> where = null;

	// search
	if (!StringUtils.isEmpty(search)) {
		where = new CandidateSpecification(seachCriteria);
	}

	// min totalMember filter
	if (filter.getMinCreator() != 0) {
		if (where != null) {
			where = where.and(new CandidateSpecification(minCreatorCriteria));
		} else {
			where = new CandidateSpecification(minCreatorCriteria);
		}
	}

	// max totalMember filter
	if (filter.getMinCreator() != 0) {
		if (where != null) {
			where = where.and(new CandidateSpecification(maxCreatorCriteria));
		} else {
			where = new CandidateSpecification(maxCreatorCriteria);
		}
	}

		return where;
	}
}
