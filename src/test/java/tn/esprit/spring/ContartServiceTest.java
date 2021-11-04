package tn.esprit.spring;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContartServiceTest {
	@Test
	public void testContextLoads() {
		
	}
/*
	@Autowired
	IEmployeService employeService;

	Contrat contrat;
	Employe employe = new Employe("flen", "ben flen", "flen@gmail.com", true, Role.ADMINISTRATEUR);
	
	private static final Logger loggerContrat = LogManager.getLogger(ContartServiceTest.class);
	
	@Test
	public void testdeleteAllContratJPQL() {
		try {
		employeService.deleteAllContratJPQL();	
		loggerContrat.info("deleteAllContratJPQL ");
		}
		catch(Exception e){loggerContrat.error("Erreur dans deleteAllContratJPQL() ");}
	}
	
	@Test
	public void testajouterContrat(){
		try {
		contrat = new Contrat(new Date(), "CDI", 300);
		employeService.ajouterContrat(contrat);
		loggerContrat.info("ajouterContrat : "+ contrat);
		}
		catch(Exception e){loggerContrat.error("Erreur dans ajouterContrat() : " + contrat);}
	}
	
	
	@Test
	public void testdeleteContratById(){
		try {
		contrat = new Contrat(new Date(), "CDI", 300);
		contrat.setReference(7);
		employeService.deleteContratById(contrat.getReference());
		loggerContrat.info("deleteContratById : "+ contrat);
		}
		catch(Exception e){loggerContrat.error("Erreur dans deleteContratById() : " + contrat);}
	}
	
	
	@Test
	public void testaffecterContratAEmploye() {
		try {
		contrat = new Contrat(new Date(), "CDI", 300);
		contrat.setReference(7);
		employe.setId(1);
		employeService.affecterContratAEmploye(contrat.getReference(),employe.getId());
		loggerContrat.info("affecterContratAEmploye : Contrat : "+ contrat +" Employe : " + employe);
		}
		catch(Exception e){loggerContrat.error("Erreur affecterContratAEmploye : Contrat : "+ contrat +" Employe : " + employe);}
	}

	
	*/
	
}
