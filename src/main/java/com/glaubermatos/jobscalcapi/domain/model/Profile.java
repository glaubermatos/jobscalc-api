package com.glaubermatos.jobscalcapi.domain.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String name;
	private String avatarUrl;
	private Integer remuneration;
	private Integer workingHoursPerDay;
	private Integer workingDaysPerWeek;
	private Integer vacationWeekPerYear;
	private Integer valueHour;
	
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
	private List<Job> jobs;
	 
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
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
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
		Profile other = (Profile) obj;
		return Objects.equals(id, other.id);
	}
}
