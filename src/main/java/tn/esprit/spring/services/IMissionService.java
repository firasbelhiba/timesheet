package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	List <Mission> getAllMissions();
	void addMission(Mission mission);
	int nbrMissions();
	List <Mission> getMissionsByDepartement(int departementId);
	void deleteMission(int Id);
	public void updateMissionName(int id ,String name);
	Optional<Mission> getMissionById(int id);
	public void affectMissionToDepartement(int missionId, int depId);

}
