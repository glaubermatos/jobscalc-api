package com.glaubermatos.jobscalcapi.api.domain.model;

import java.time.OffsetDateTime;

import com.glaubermatos.jobscalcapi.domain.model.JobStatus;

public class JobModel {
	
	private Long id;	
	private String name;	
	private Integer workingHoursPerDay;	
	private Integer hoursEstimate;	
	private Integer projectValue;
	private OffsetDateTime dateProjectStart;
	private String deadline;
	private OffsetDateTime createdAt;	
	private OffsetDateTime closedAt;
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
	public Integer getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}
	public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}
	public Integer getHoursEstimate() {
		return hoursEstimate;
	}
	public void setHoursEstimate(Integer hoursEstimate) {
		this.hoursEstimate = hoursEstimate;
	}
	public Integer getProjectValue() {
		return projectValue;
	}
	public void setProjectValue(Integer projectValue) {
		this.projectValue = projectValue;
	}
	public OffsetDateTime getDateProjectStart() {
		return dateProjectStart;
	}
	public void setDateProjectStart(OffsetDateTime dateProjectStart) {
		this.dateProjectStart = dateProjectStart;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public OffsetDateTime getClosedAt() {
		return closedAt;
	}
	public void setClosedAt(OffsetDateTime closedAt) {
		this.closedAt = closedAt;
	}
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
}
