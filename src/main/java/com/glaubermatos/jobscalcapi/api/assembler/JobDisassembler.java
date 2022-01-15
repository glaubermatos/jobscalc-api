package com.glaubermatos.jobscalcapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.glaubermatos.jobscalcapi.api.domain.model.input.JobInput;
import com.glaubermatos.jobscalcapi.domain.model.Job;

@Component
public class JobDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Job toDomainModel(JobInput jobInput) {
		return modelMapper.map(jobInput, Job.class);
	}
	
	public void copyToDomainObject(JobInput jobInput, Job job) {
        /**
         * Ok, this line is not trivial to understand.
         * What is happening here is that the Cuisine and Address on the restaurant are managed by JPA, but this
         * operation is only changing the reference of a Cuisine on a Restaurant (or a City on an Address). For this
         * reason we change the Cuisine and Address to a new one to them update its references to a new Cuisine and
         * City from the Address.
         *
         * To be honest I don't like this solution, but I don't have a better one. =(
         */
       

        modelMapper.map(jobInput, job);
    }
}
