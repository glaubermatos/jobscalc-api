package com.glaubermatos.jobscalcapi.api.domain.model;

import com.glaubermatos.jobscalcapi.domain.model.JobStatus;

public class SimpleJobRepresentation {

	private Long id;
	private String name;
	private String deadline;
	private Integer projectValue;
	private JobStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Integer getProjectValue() {
		return projectValue;
	}

	public void setProjectValue(Integer projectValue) {
		this.projectValue = projectValue;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}
}
