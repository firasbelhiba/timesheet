package tn.esprit.spring;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import java.util.Optional;
import java.util.List;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	@Test
	public void testContextLoads() {
		
	}
	/*
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService iEmployeService;
	@Autowired
	IEntrepriseService iEntrepriseService;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private DepartementRepository departementRepository;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	
	public void testAjouterEmploye() throws ParseException {
		Employe employe = new Employe( "Ghada", "Khedri", "ghada.khedri1@esprit.tn", true, Role.INGENIEUR);
		iEmployeService.ajouterEmploye(employe);
		assertThat(employe.getNom()).isEqualTo("Ghada");
	}

	@Test
	public void testMettreAjourEmailByEmployeIdJPQL() throws ParseException {
		employeService.mettreAjourEmailByEmployeIdJPQL("ghadakhedrib@gmail.com",2);
		assertThat(employeRepository.findById(2).get().getEmail()).isEqualTo("ghadakhedrib@gmail.com");
	}
	
	@Test
	public void testAffectEmployeDepartment() throws ParseException {
		employeService.affecterEmployeADepartement(2,1);
		assertThat(employeRepository.findById(2).get()).isNotNull();
		assertThat(departementRepository.findById(1).get()).isNotNull();
		
	}
	@Test
	public void testDesaffecterEmployeDuDepartement() throws ParseException {
		employeService.desaffecterEmployeDuDepartement(2,1);
		assertThat(employeRepository.findById(2).get()).isNotNull();
		assertThat(departementRepository.findById(1).get()).isNotNull();
	}  

	@Test
	public void testAjouterContrat() throws ParseException {
		Date date = dateFormatter.parse("10/10/2021");
		Contrat contrat = new Contrat(date,"stage pfe ",400);
		assertEquals(contrat.getReference(), employeService.ajouterContrat(contrat));
		
	}
	
	@Test
	public void testAffecterContratAEmploye() throws ParseException {
		employeService.affecterContratAEmploye(1,2);
		assertThat(employeRepository.findById(2).get()).isNotNull();
		assertThat(contratRepository.findById(1).get()).isNotNull();
	}

	@Test
	public void testGetEmployePrenomById() throws ParseException {
		String prenom =employeService.getEmployePrenomById(2);
		assertThat(prenom).isEqualTo("Ghada");
	}  
	@Test
	public void testDeleteEmployeById() throws ParseException {
		employeService.deleteEmployeById(2);
		Optional<Employe> deletedEmploye = employeRepository.findById(2);
		assertThat(deletedEmploye).isEmpty();
		
	} 
	@Test
	public void testDeleteContratById() throws ParseException {
		employeService.deleteContratById(1);
		Optional<Contrat> deleteContrat = contratRepository.findById(2);
		assertThat(deleteContrat).isEmpty();
	
	} 
	@Test
	public void testGetNombreEmployeJPQL() throws ParseException {
		int nombre =employeService.getNombreEmployeJPQL();
		assertThat(nombre).isEqualTo(2);
	}

	@Test
	public void testGetEmployesByEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise("Trame","photographe");
		iEntrepriseService.ajouterEntreprise(entreprise);
		List<Employe> employes = employeService.getAllEmployeByEntreprise(entreprise);
		assertThat(employes.size()).isEqualTo(1);
	}
	
	@Test
	public void testDeleteAllContratJPQL() throws ParseException {
		employeService.deleteAllContratJPQL();
		verify(employeService,times(1)).deleteAllContratJPQL();
	}
	@Test
	public void testGetSalaireMoyenByDepartementId() throws ParseException {
		Double salaireMoyen=employeService.getSalaireMoyenByDepartementId(1);
		assertThat(salaireMoyen).isEqualTo(2);
	}
	@Test
	public void testGetAllEmployeNamesJPQL() throws ParseException {
		List<String> names = employeService.getAllEmployeNamesJPQL();
		assertThat(names.get(0)).isEqualTo("Ghada");
	}
	*/
}
