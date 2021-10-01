package com.vti.dto.filter;

public class CandidateFilter {
	private int minCreator;

	private int maxCreator;

	public CandidateFilter() {
	}

	public int getMinCreator() {
		return minCreator;
	}

	public void setMinCreator(int minCreator) {
		this.minCreator = minCreator;
	}

	public int getMaxCreator() {
		return maxCreator;
	}

	public void setMaxCreator(int maxCreator) {
		this.maxCreator = maxCreator;
	}
}
