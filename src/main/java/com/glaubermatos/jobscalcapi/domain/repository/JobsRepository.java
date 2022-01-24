package com.glaubermatos.jobscalcapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaubermatos.jobscalcapi.domain.model.Job;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {

	public Optional<Job> findByNameAndProfileId(String name, Long profileId);
	public List<Job> findByProfileId(Long profileId);
}
