package com.glaubermatos.jobscalcapi.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaubermatos.jobscalcapi.domain.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

	public Optional<Profile> findByEmail(String email);
}
