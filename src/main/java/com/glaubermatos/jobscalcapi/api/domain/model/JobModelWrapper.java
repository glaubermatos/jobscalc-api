package com.glaubermatos.jobscalcapi.api.domain.model;

import java.util.List;

public class JobModelWrapper {

	private Integer totalProjects;
	private Integer totalProjectsInProgress;
	private Integer totalProjectsClosed;
	private List<JobModel> jobs;
	
	public Integer getTotalProjects() {
		return totalProjects;
	}
	public void setTotalProjects(Integer totalProjects) {
		this.totalProjects = totalProjects;
	}
	public Integer getTotalProjectsInProgress() {
		return totalProjectsInProgress;
	}
	public void setTotalProjectsInProgress(Integer totalProjectsInProgress) {
		this.totalProjectsInProgress = totalProjectsInProgress;
	}
	public Integer getTotalProjectsClosed() {
		return totalProjectsClosed;
	}
	public void setTotalProjectsClosed(Integer totalProjectsClosed) {
		this.totalProjectsClosed = totalProjectsClosed;
	}
	public List<JobModel> getJobs() {
		return jobs;
	}
	public void setJobs(List<JobModel> jobs) {
		this.jobs = jobs;
	}
}
