package com.plantplaces.service;

import org.springframework.stereotype.Component;

import com.plantplaces.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService 
{
   
	@Override
	public SpecimenDTO fetchById(int id)
	{
		SpecimenDTO specimenDTO = new SpecimenDTO();
	    specimenDTO.setSpecimenId(43);
	    specimenDTO.setLatitute("39.74");
	    specimenDTO.setLongitude("-84.71");
	    specimenDTO.setDescription("A beautiful Eastern Redbud");
	    
		return specimenDTO;
	}
	
	@Override
	public void save(SpecimenDTO specimenDTO)
	{
		
	}
}
