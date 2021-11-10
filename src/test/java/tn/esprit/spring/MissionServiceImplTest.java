package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IMissionService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	
	@Autowired
	IMissionService iMissionService;
	@Autowired
	MissionRepository missionRepository;
	
	public void testAddMissionExterne() throws ParseException{
	}

	@Test
	public void testAddMission() throws ParseException{
		Mission mission = new Mission("Mission2","Lorem Ipsum dolore");
		iMissionService.addMission(mission);
		assertThat(mission.getName()).isEqualTo("Mission2");
	
	}

	
	/* webhook */

			/* webhook */	/* webhook */	/* webhook */
		/* webhook */
			/* webhook */	/* webhook */
	/*	@Test
	public void testDisplayMissions() throws ParseException{
		
		List<Mission> missions =  iMissionService.getAllMissions(); 
		assertThat(missions.size()).isEqualTo(10);	
	}
	
	
	@Test
	public void testDeleteMission()  throws Exception {
		iMissionService.deleteMission(2);;
		Optional<Mission> deletedMission = missionRepository.findById(2);
		assertThat(deletedMission).isEmpty();
		}
	*/
	
	@Test
	public void testUpdateMission() throws ParseException {
		iMissionService.updateMissionName(3,"MissionUpdated");
		assertThat(missionRepository.findById(3).get().getName()).isEqualTo("MissionUpdated");
	}

	
	
	
}
