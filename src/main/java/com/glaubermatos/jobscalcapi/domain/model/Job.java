package com.glaubermatos.jobscalcapi.domain.model;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;
	private Integer workingHoursPerDay;
	private Integer hoursEstimate;
	private Integer projectValue;
	private OffsetDateTime dateProjectStart;
	private OffsetDateTime createdAt;
	private OffsetDateTime closedAt;
	@Enumerated(EnumType.STRING)
	private JobStatus status;
	@Transient
	private String deadline;

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
		if (status.equals(JobStatus.INPROGRESS)) {
			setProjectStart(OffsetDateTime.now());
		} else if (status.equals(JobStatus.CLOSED)) {
			setClosedAt(OffsetDateTime.now());
		} else if (status.equals(JobStatus.NOTSTARTED)) {
			setProjectStart(null);
			setClosedAt(null);
		}
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public OffsetDateTime getProjectStart() {
		return dateProjectStart;
	}

	public void setProjectStart(OffsetDateTime projectStart) {
		this.dateProjectStart = projectStart;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@PostLoad
	public void calcDeadline() {
		Integer workingHoursPerDay = profile.getWorkingHoursPerDay() * 100;
		Integer hoursEstimateToClosedProject = hoursEstimate * 100;

		Integer daysEstimateToClosedProject = hoursEstimateToClosedProject / workingHoursPerDay;

		StringBuilder deadlineBuilder = new StringBuilder();

		if (status.equals(JobStatus.INPROGRESS)) {
			OffsetDateTime currentDate = OffsetDateTime.now();
			OffsetDateTime dateProjectStart = this.dateProjectStart;

			Integer daysOfProjectStart = (int) dateProjectStart.until(currentDate, ChronoUnit.DAYS);

			deadlineBuilder.append(daysEstimateToClosedProject - daysOfProjectStart);
			deadlineBuilder.append(" dias para entrega");

			setDeadline(deadlineBuilder.toString());

		} else if (status.equals(JobStatus.NOTSTARTED)) {
			deadlineBuilder.append(daysEstimateToClosedProject);
			deadlineBuilder.append(" dias");

			setDeadline(deadlineBuilder.toString());
		}
	}

	public void changeStatusToInProgress() {
		if (status.equals(JobStatus.NOTSTARTED)) {
			setStatus(JobStatus.INPROGRESS);
			setProjectStart(OffsetDateTime.now());
		}
	}

	public void changeStatusToClosed() {
		if (status.equals(JobStatus.INPROGRESS)) {
			setStatus(JobStatus.CLOSED);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(id, other.id);
	}

}
