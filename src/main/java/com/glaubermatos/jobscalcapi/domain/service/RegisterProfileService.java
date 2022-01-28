package com.glaubermatos.jobscalcapi.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaubermatos.jobscalcapi.domain.exceptions.EntityNotFoundException;
import com.glaubermatos.jobscalcapi.domain.model.Profile;
import com.glaubermatos.jobscalcapi.domain.repository.ProfileRepository;

@Service
public class RegisterProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;

	@Transactional
	public Profile save(Profile profile) {
		Optional<Profile> profileOptional = profileRepository.findByEmail(profile.getEmail());
		
		if (profileOptional.isPresent()) {
			return profileOptional.get();
		}
		
		return profileRepository.save(profile);
	}
	
	public Profile findByIdOrError(Long id) {
		return profileRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String
						.format("Perfil de código %d não encontrado", id)));
	}
	
	public Profile findByEmailOrError(String email) {
		return profileRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException(String
						.format("Não existe perfil cadastrado com o email %s", email)));
	}
}
