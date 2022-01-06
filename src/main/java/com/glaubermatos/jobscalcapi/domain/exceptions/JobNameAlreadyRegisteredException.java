package com.glaubermatos.jobscalcapi.domain.exceptions;

public class JobNameAlreadyRegisteredException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public JobNameAlreadyRegisteredException(String message) {
		super(message);
	}

}
