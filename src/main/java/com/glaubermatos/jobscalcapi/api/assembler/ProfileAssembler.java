package com.glaubermatos.jobscalcapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.ProfileModel;
import com.glaubermatos.jobscalcapi.domain.model.Profile;

@Component
public class ProfileAssembler {
	
	@Autowired
	private ModelMapper modalMapper;
	
	public ProfileModel toModel(Profile profile) {
		return modalMapper.map(profile, ProfileModel.class);
	}

}
