package com.glaubermatos.jobscalcapi.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glaubermatos.jobscalcapi.api.assembler.JobAssembler;
import com.glaubermatos.jobscalcapi.api.assembler.JobDisassembler;
import com.glaubermatos.jobscalcapi.api.domain.model.JobModel;
import com.glaubermatos.jobscalcapi.api.domain.model.input.JobInput;
import com.glaubermatos.jobscalcapi.domain.model.Job;
import com.glaubermatos.jobscalcapi.domain.model.Profile;
import com.glaubermatos.jobscalcapi.domain.service.RegisterJobService;
import com.glaubermatos.jobscalcapi.domain.service.RegisterProfileService;

@RestController
@RequestMapping("/api/profile/{profileId}/jobs")
public class JobsController {
	
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
		
		return jobAssembler.toModel(registerJobService.save(newJob));
	}
}
