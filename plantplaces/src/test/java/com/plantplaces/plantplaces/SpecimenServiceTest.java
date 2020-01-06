package com.plantplaces.plantplaces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plantplaces.dto.PlantDTO;
import com.plantplaces.service.ISpecimenService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpecimenServiceTest 
{
	@Autowired
	ISpecimenService specimenService;
	List<PlantDTO> plants;
    
	@Test
	public void fetchPlants_validateResultsForJunkData()
 {
	 givenUserIsLoggedInToMyPlantDiary();
	 whenTheUserSearchesForJunk();
	 thenMyPlantDiaryReturnsZeroResults();
 }

	private void givenUserIsLoggedInToMyPlantDiary() {
		// TODO Auto-generated method stub
		
	}

	private void whenTheUserSearchesForJunk() {
	 plants	= specimenService.fetchPlants("kajsd;luaopuidfjo");
		
	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned",0,plants.size());
		
	}
	
}
