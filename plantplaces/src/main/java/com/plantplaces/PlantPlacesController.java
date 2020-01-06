package com.plantplaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.dto.SpecimenDTO;
import com.plantplaces.service.ISpecimenService;

@Controller
public class PlantPlacesController 
{
	@Autowired
	private ISpecimenService specimenService;
	
	@RequestMapping(value="/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO)
	{
	    specimenDTO.setPlantId(13);
		return "start";
	}

	@RequestMapping(value="/start",method=RequestMethod.GET)
	public String read(Model model)
	{
		model.addAttribute("specimenDTO", new SpecimenDTO());
		return "start";  
	}

	@RequestMapping(value="/addSpecimen",method=RequestMethod.GET)
	public String addSpecimen(Model model, @RequestParam(value="latitude",required=false) String latitude)
	{
		SpecimenDTO specimenDTO = specimenService.fetchById(43);
		specimenDTO.setLatitute(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";  
	}

	@RequestMapping("/")
	public String index()
	{
		return "start";  
	}
	
	@RequestMapping("/searchPlants1")
	public String searchPlants(@RequestParam(value="searchTerm",required=false) String searchTerm)
	{
		String enhancedTerm= searchTerm + "";
		List<PlantDTO> fetchPlants = specimenService.fetchPlants(searchTerm);
		return "start";
	}

	@RequestMapping("/searchPlantsAll")
	public String searchPlantsAll(@RequestParam Map<String,String> requestParams)
	{
		int params= requestParams.size();
		requestParams.get("searchTerm");
		return "start";
	}
	
	@RequestMapping("/sustainability")
	public String sustainabilty()
	{
		return "sustainability";
	}
	
}
