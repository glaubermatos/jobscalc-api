package com.glaubermatos.jobscalcapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaubermatos.jobscalcapi.domain.exceptions.EntityNotFoundException;
import com.glaubermatos.jobscalcapi.domain.exceptions.JobNameAlreadyRegisteredException;
import com.glaubermatos.jobscalcapi.domain.model.Job;
import com.glaubermatos.jobscalcapi.domain.model.Profile;
import com.glaubermatos.jobscalcapi.domain.repository.JobsRepository;

@Service
public class RegisterJobService {
	
	@Autowired
	RegisterProfileService registerProfileService;
	
	@Autowired
	private JobsRepository jobRepository;

	@Transactional
	public Job save(Job job, Long profileId) {
		if (job.getId() == null) { 
			Boolean jobNameAlreadyExists = jobRepository.findByNameAndProfileId(job.getName(), profileId).isPresent();
			
			if (jobNameAlreadyExists) {
				throw new JobNameAlreadyRegisteredException(String
						.format("Já existe um Job %s", job.getName()));
			} 
		}
		
		return jobRepository.save(job);
	}

	@Transactional
	public void delete(Long profileId, Long jobId) {		

		Profile profile = registerProfileService.findByIdOrError(profileId);
		
		if (!profile.getJobs().stream().anyMatch(job -> job.getId().equals(jobId))) {
			throw new EntityNotFoundException(String
					.format("Job de id %d não pode ser excluído porque não existe", jobId));
		}
		
		if (notCanDeleteJob(jobId)) {
			throw new EntityNotFoundException(String
					.format("Job de ID %d não pode ser excluído porque não existe.", jobId));
		}
		
		jobRepository.deleteById(jobId);
		
	}
	
	public Job findByIdOrError(Long profileId, Long jobId) {
		Job job = jobRepository.findById(jobId)
				.orElseThrow(() -> new EntityNotFoundException(String
						.format("Job com id %d não existe para o perfil informado", jobId)));
		
		if (!job.getProfile().getId().equals(profileId)) {
			throw new EntityNotFoundException(String
					.format("Job com id %d não existe para o perfil informado", jobId));
		}
		
		return job;
	}
	
	private Boolean notCanDeleteJob(Long id) {
		return !canDeleteJob(id);
	}
	
	private Boolean canDeleteJob(Long id) {
		return jobRepository.existsById(id);
	}

	@Transactional
	public void changeStatusJobToInProgress(Job job) {
		job.changeStatusToInProgress();
	}

	@Transactional
	public void changeStatusJobToClosed(Job job) {
		job.changeStatusToClosed();
	}
}
