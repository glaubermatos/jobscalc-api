package com.glaubermatos.jobscalcapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.JobModel;
import com.glaubermatos.jobscalcapi.domain.model.Job;

@Component
public class JobAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public JobModel toModel(Job job) {
		return modelMapper.map(job, JobModel.class);
	}
	
	public List<JobModel> toCollectionModel(List<Job> jobs) {
		return jobs.stream()
				.map(job -> toModel(job))
				/* .map(this::toModel) */
				.collect(Collectors.toList());
	}
}
