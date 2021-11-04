package tn.esprit.spring;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {
	
	@Autowired
	IEntrepriseService entrepriseService;
	
	@Autowired
	IEmployeService employeService;
	
	@Autowired
	ITimesheetService timesheetService;
	
	private static final Logger loggerDepartement = LogManager.getLogger(DepartementServiceImplTest.class);
	
	@Test
	public void testajouterDepartement() {
		try {
			Departement dept = new Departement("dep4");
			entrepriseService.ajouterDepartement(dept);
			loggerDepartement.info("Departement Ajouté : " + dept);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testdeleteDepartementById() {
		try {
			entrepriseService.deleteDepartementById(5);
			loggerDepartement.info("Departement Supprimé");
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testaffecterDepartementAEntreprise() {
		try {
			entrepriseService.affecterDepartementAEntreprise(16, 16);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testgetAllDepartementsNamesByEntreprise() {
		try {
			entrepriseService.getAllDepartementsNamesByEntreprise(1);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testaffecterEmployeADepartement() {
		try {
			employeService.affecterEmployeADepartement(16, 16);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testdesaffecterEmployeDuDepartement() {
		try {
			employeService.desaffecterEmployeDuDepartement(6, 6);
		}
		catch(Exception e){
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testgetSalaireMoyenByDepartementId() {
		try {
			employeService.getSalaireMoyenByDepartementId(1);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
	
	@Test
	public void testaffecterMissionADepartement() {
		try {
			timesheetService.affecterMissionADepartement(14, 14);
		}
		catch(Exception e) {
			loggerDepartement.error(e);
		}
	}
}