package com.glaubermatos.jobscalcapi.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glaubermatos.jobscalcapi.api.assembler.ProfileAssembler;
import com.glaubermatos.jobscalcapi.api.assembler.ProfileDisassembler;
import com.glaubermatos.jobscalcapi.api.domain.model.ProfileModel;
import com.glaubermatos.jobscalcapi.api.domain.model.input.ProfileInput;
import com.glaubermatos.jobscalcapi.domain.model.Profile;
import com.glaubermatos.jobscalcapi.domain.service.RegisterProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileAssembler profileAssembler;
	
	@Autowired
	private RegisterProfileService registerProfileService;
	
	@Autowired
	private ProfileDisassembler profileDisassembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profile create(@RequestBody @Valid ProfileInput input) {
		return registerProfileService.save(profileDisassembler
				.toDomainModel(input));
	}
	
	@GetMapping("/{email}")
	public ProfileModel show(@PathVariable String email) {
		return profileAssembler.toModel(registerProfileService.findByEmailOrError(email)) ;
	}

}
