package com.glaubermatos.jobscalcapi.api.domain.model;

public class ProfileModel {

	private Long id;
	private String email;
	private String name;
	private String avatarUrl;
	private Integer remuneration;
	private Integer workingHoursPerDay;
	private Integer workingDaysPerWeek;
	private Integer vacationWeekPerYear;
	private Integer valueHour;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
