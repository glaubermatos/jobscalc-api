package com.glaubermatos.jobscalcapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaubermatos.jobscalcapi.domain.exceptions.JobNameAlreadyRegisteredException;
import com.glaubermatos.jobscalcapi.domain.model.Job;
import com.glaubermatos.jobscalcapi.domain.repository.JobsRepository;

@Service
public class RegisterJobService {
	
	@Autowired
	private JobsRepository jobRepository;

	@Transactional
	public Job save(Job job) {
		Boolean jobNameExists = jobRepository.findByName(job.getName()).isPresent();
		
		if (jobNameExists) {
			throw new JobNameAlreadyRegisteredException("Já existe um regstro de Job com o nome informado");
		}
		
		return jobRepository.save(job);
	}
}
