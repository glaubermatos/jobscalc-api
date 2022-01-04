package com.glaubermatos.jobscalcapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaubermatos.jobscalcapi.domain.model.Job;
import com.glaubermatos.jobscalcapi.domain.repository.JobsRepository;

@Service
public class RegisterJobService {
	
	@Autowired
	private JobsRepository jobRepository;

	@Transactional
	public Job save(Job job) {
		return jobRepository.save(job);
	}
}
