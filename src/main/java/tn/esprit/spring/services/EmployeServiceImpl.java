package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	
	private static final Logger logger = Logger.getLogger(EmployeServiceImpl.class);

	public int ajouterEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe employe = employeRepository.findById(employeId).orElse(null);
		try{
			employe.setEmail(email);
			employeRepository.save(employe);
			logger.info("Email updated");}
			catch (Exception e) {
				logger.error("Error in mettreAjourEmailByEmployeId : " + e);

		}

	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
		if(depManagedEntity.getEmployes() == null){
			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
			logger.info("employee affected");
		}else{
			depManagedEntity.getEmployes().add(employeManagedEntity);
			logger.info("employee affected");
		}


	}
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Departement dep = deptRepoistory.findById(depId).orElse(null);

		int employeNb = dep.getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.getEmployes().get(index).getId() == employeId){
				dep.getEmployes().remove(index);
				logger.info("the employe is desaffected");
				break;//a revoir
			}
		}
	}

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		logger.info("the contrat is added");
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);

		contratManagedEntity.setEmploye(employeManagedEntity);
		logger.info("the contrat is affected");
		contratRepoistory.save(contratManagedEntity);
		
	}

	public String getEmployePrenomById(int employeId) {
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
		logger.info("the employe is  "+employeManagedEntity.getPrenom());
		return employeManagedEntity.getPrenom();
	}
	public void deleteEmployeById(int employeId)
	{
		Employe employe = employeRepository.findById(employeId).orElse(null);

		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);

		}

		employeRepository.delete(employe);
		logger.info("the employe is removed");
	}

	public void deleteContratById(int contratId) {
		try{
			Contrat contratManagedEntity = contratRepoistory.findById(contratId).orElse(null);		
			contratRepoistory.delete(contratManagedEntity);
			logger.info("the contrat is removed");
			}
			catch (Exception e) {
				logger.error("Error : id not found " + e);
			}

	}

	public int getNombreEmployeJPQL() {
		logger.info("Empolyees number : "+employeRepository.countemp());
		return employeRepository.countemp();
	}
	
	public List<String> getAllEmployeNamesJPQL() {
		logger.info("Employee name : "+employeRepository.employeNames());
		return employeRepository.employeNames();

	}
	
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		logger.info("Employees name are : "+employeRepository.getAllEmployeByEntreprisec(entreprise));
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	public void deleteAllContratJPQL() {
         employeRepository.deleteAllContratJPQL();
	}
	
	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		logger.info("the average of salaries is "+employeRepository.getSalaireMoyenByDepartementId(departementId));
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}
	
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		logger.info("List employees:"+ employeRepository.findAll());
				return (List<Employe>) employeRepository.findAll();
	}

}
