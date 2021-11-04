package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	
//	private static final Logger logger = Logger.getLogger(TimesheetServiceImpl.class);
	private static final Logger logger = LogManager.getLogger(TimesheetServiceImpl.class);

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public List<Mission> getAllMissions() {
		List<Mission> missions= (List<Mission>) missionRepository.findAll();
		logger.info("Mission's List :" + missions);
		return missions;
	}
	
	@Override
	public void deleteMission(int Id) {
		missionRepository.deleteById(Id);
		logger.info("Mission deleted", Id);
		
	}

	@Override
	public void addMission(Mission mission) {
		missionRepository.save(mission);
		logger.info("success");
		
	}

	@Override
	public int nbrMissions() {
		int nb = (int) missionRepository.numberMissions();
		logger.info("Nbr of missions: " +nb);
		return nb;
	}

	@Override
	public List<Mission> getMissionsByDepartement(int departementId) {
		Departement dep = departementRepository.findById(departementId).get();
		List<Mission> missions = new ArrayList<>();
		for(Mission mis : missionRepository.findAll()){
			if (mis.getDepartement() == dep){
				missions.add(mis);			
			}
		}	
		logger.info("Mission's by departments :" + missions);
		
		return missions;
		
	}

	@Override
	public void affectMissionToDepartement(int missionId, int depId) {
		Mission mission = missionRepository.findById(missionId).get();
		Departement dep = departementRepository.findById(depId).get();
		mission.setDepartement(dep);
		missionRepository.save(mission);
		logger.info("Mission " + mission+" affected with success to department " + dep);

		
	}
	
	@Override
	public Optional<Mission> getMissionById(int id) {
    Optional<Mission> mission=missionRepository.findById(id);
		return mission;
	}

	
	
	@Override
	public void updateMissionName(int id, String name) {
		Mission missionToUpdate = missionRepository.findById(id).orElse(null);
        try{
        	missionToUpdate.setName(name);
        	missionRepository.save(missionToUpdate);
            logger.info("Mission updated");}
            catch (Exception e) {
                logger.error("Error in update mission function  : " + e);

        }
		
	}

	
	
}
