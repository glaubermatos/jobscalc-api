package com.glaubermatos.jobscalcapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.input.JobInput;
import com.glaubermatos.jobscalcapi.domain.model.Job;

@Component
public class JobDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Job toDomainModel(JobInput input) {
		return modelMapper.map(input, Job.class);
	}
}
