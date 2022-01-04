package com.glaubermatos.jobscalcapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaubermatos.jobscalcapi.domain.model.Job;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {

}
