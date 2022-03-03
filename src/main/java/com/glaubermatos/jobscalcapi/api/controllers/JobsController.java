package com.glaubermatos.jobscalcapi.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glaubermatos.jobscalcapi.api.assembler.JobAssembler;
import com.glaubermatos.jobscalcapi.api.assembler.JobDisassembler;
import com.glaubermatos.jobscalcapi.api.domain.model.JobModel;
import com.glaubermatos.jobscalcapi.api.domain.model.JobModelWrapper;
import com.glaubermatos.jobscalcapi.api.domain.model.input.JobInput;
import com.glaubermatos.jobscalcapi.domain.exceptions.JobNameAlreadyRegisteredException;
import com.glaubermatos.jobscalcapi.domain.model.Job;
import com.glaubermatos.jobscalcapi.domain.model.JobStatus;
import com.glaubermatos.jobscalcapi.domain.model.Profile;
import com.glaubermatos.jobscalcapi.domain.service.RegisterJobService;
import com.glaubermatos.jobscalcapi.domain.service.RegisterProfileService;

@RestController
@RequestMapping("/api/profiles/{profileId}/jobs")
public class JobsController {
	
	@Autowired
	private JobDisassembler jobDisassembler;
	
	@Autowired
	private JobAssembler jobAssembler;
	
	@Autowired
	private RegisterJobService registerJobService;
	
	@Autowired
	private JobDisassembler jobDisssember;
	
	@Autowired
	private RegisterProfileService registerProfileService;

	@PostMapping
	public JobModel create(@RequestBody @Valid JobInput input, @PathVariable Long profileId) {
		Profile profile = registerProfileService.findByIdOrError(profileId);
		Job newJob = jobDisssember.toDomainModel(input);
		newJob.setProfile(profile);
		
		return jobAssembler.toModel(registerJobService.save(newJob, profileId));
	}
	
	@GetMapping
	public JobModelWrapper index(@PathVariable Long profileId) {
		Profile profile = registerProfileService.findByIdOrError(profileId);
		
		List<Job> jobs = profile.getJobs();
		
		Integer totalProjects = jobs.size();
		
		Integer totalJobsInProgress = jobs.stream()
				.filter(job -> job.getStatus() == JobStatus.INPROGRESS)
				.collect(Collectors.toList())
				.size();
		
		Integer totalProjectsClosed = jobs.stream()
				.filter(job -> job.getStatus() == JobStatus.CLOSED)
				.collect(Collectors.toList())
				.size();		
		
		JobModelWrapper jobWrapper = new JobModelWrapper();
		jobWrapper.setTotalProjects(totalProjects);
		jobWrapper.setTotalProjectsInProgress(totalJobsInProgress);
		jobWrapper.setTotalProjectsClosed(totalProjectsClosed);
		jobWrapper.setJobs(jobAssembler.toCollectionModel(profile.getJobs()));
		
		return jobWrapper;
	}
	
	@DeleteMapping("/{jobId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long profileId, @PathVariable Long jobId) {
		registerJobService.delete(profileId, jobId);		
	}
	
	@GetMapping("/{jobId}")
	public JobModel show(@PathVariable Long profileId, @PathVariable Long jobId) {
		return jobAssembler
				.toModel(registerJobService
						.findByIdOrError(profileId, jobId));
	}
	
	@PutMapping("/{jobId}")
	@ResponseStatus(HttpStatus.OK)
	public JobModel update(@PathVariable Long profileId, @PathVariable Long jobId, @RequestBody @Valid JobInput jobInput) {
		Job jobToUpdate = registerJobService.findByIdOrError(profileId, jobId);
		
		try {
			jobDisassembler.copyToDomainObject(jobInput, jobToUpdate);
			return jobAssembler.toModel(registerJobService.save(jobToUpdate, profileId));
		} catch (DataIntegrityViolationException e) {
			throw new JobNameAlreadyRegisteredException(String
					.format("Já existe um Job %s", jobInput.getName()));
		}
		
	}
	
	@PutMapping("/{jobId}/inprogress")
	@ResponseStatus(HttpStatus.OK)
	public void inProgress(@PathVariable Long profileId, @PathVariable Long jobId) {
		Job job = registerJobService.findByIdOrError(profileId, jobId);
		registerJobService.changeStatusJobToInProgress(job);
	}
	
	@PutMapping("/{jobId}/closed")
	@ResponseStatus(HttpStatus.OK)
	public void closed(@PathVariable Long profileId, @PathVariable Long jobId) {
		Job job = registerJobService.findByIdOrError(profileId, jobId);
		registerJobService.changeStatusJobToClosed(job);
	}
}
