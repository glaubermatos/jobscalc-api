package com.glaubermatos.jobscalcapi.api.domain.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ProfileInput {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String avatarUrl;
	
	@NotNull
	@Min(100)
	private Integer remuneration;
	
	@NotNull
	@Min(3600)  //1 hora
	@Max(86400) //24 horas
	private Integer workingHoursPerDay;
	
	@NotNull
	@Min(1)
	@Max(7)
	private Integer workingDaysPerWeek;
	
	@NotNull
	@PositiveOrZero
	@Max(52)
	private Integer vacationWeekPerYear;
	
	@NotNull
	@PositiveOrZero
	private Integer valueHour;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public Integer getRemuneration() {
		return remuneration;
	}
	public void setRemuneration(Integer remuneration) {
		this.remuneration = remuneration;
	}
	public Integer getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}
	public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}
	public Integer getWorkingDaysPerWeek() {
		return workingDaysPerWeek;
	}
	public void setWorkingDaysPerWeek(Integer workingDaysPerWeek) {
		this.workingDaysPerWeek = workingDaysPerWeek;
	}
	public Integer getVacationWeekPerYear() {
		return vacationWeekPerYear;
	}
	public void setVacationWeekPerYear(Integer vacationWeekPerYear) {
		this.vacationWeekPerYear = vacationWeekPerYear;
	}
	public Integer getValueHour() {
		return valueHour;
	}
	public void setValueHour(Integer valueHour) {
		this.valueHour = valueHour;
	}
}
