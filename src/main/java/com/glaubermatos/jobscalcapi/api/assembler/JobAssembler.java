package com.glaubermatos.jobscalcapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.JobModel;
import com.glaubermatos.jobscalcapi.api.domain.model.SimpleJobRepresentation;
import com.glaubermatos.jobscalcapi.domain.model.Job;

@Component
public class JobAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public JobModel toModel(Job job) {
		return modelMapper.map(job, JobModel.class);
	}
	
	public List<SimpleJobRepresentation> toCollectionModel(List<Job> jobs) {
		return jobs.stream()
				.map(job -> modelMapper.map(job, SimpleJobRepresentation.class))
				/* .map(this::toModel) */
				/*.toList();*/
				.collect(Collectors.toList());
	}
}
