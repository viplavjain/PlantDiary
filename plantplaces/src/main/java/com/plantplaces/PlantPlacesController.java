package com.plantplaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller
public class PlantPlacesController 
{
	@Autowired
	private ISpecimenService specimenServiceStub;
    
	@RequestMapping(value="/start",method=RequestMethod.GET)
	public String read(Model model)
  {
	SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
	model.addAttribute("specimenDTO", specimenDTO);
	return "start";  
  }
	
	@RequestMapping(value="/addSpecimen",method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude") String latitude)
  {
	SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
	specimenDTO.setLatitute(latitude);
	model.addAttribute("specimenDTO", specimenDTO);
	return "start";  
  }
    
    @RequestMapping("/")
	public String index()
  {
	return "start";  
  }
	
}
