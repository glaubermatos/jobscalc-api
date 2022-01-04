package com.glaubermatos.jobscalcapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.input.ProfileInput;
import com.glaubermatos.jobscalcapi.domain.model.Profile;

@Component
public class ProfileDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Profile toDomainModel(ProfileInput input) {
		return modelMapper.map(input, Profile.class);
	}
}
