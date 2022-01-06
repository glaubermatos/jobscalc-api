package com.glaubermatos.jobscalcapi.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;	
	private Integer workingHoursPerDay;	
	private Integer hoursEstimate;	
	private Integer projectValue;
	private OffsetDateTime createdAt;
	private OffsetDateTime closedAt;
	@Enumerated(EnumType.STRING)
	private JobStatus status;
	
	@ManyToOne
	@JoinColumn(nullable = false, updatable = false)
	private Profile profile;
	
	public Job() {
		super();
		this.createdAt = OffsetDateTime.now();
		this.status = JobStatus.NOTSTARTED;
	}	
	
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
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	
}
