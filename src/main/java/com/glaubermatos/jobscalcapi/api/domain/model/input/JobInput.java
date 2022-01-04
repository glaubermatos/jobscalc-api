package com.glaubermatos.jobscalcapi.api.domain.model.input;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class JobInput {

	@NotBlank
	private String name;
	
	@NotNull
	@Min(3600)
	@Max(86400)
	private Integer workingHoursPerDay;
	
	@NotNull
	@Min(3600)
	private Integer hoursEstimate;
	
	@NotNull
	@Positive
	private Integer projectValue;

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
	
}
