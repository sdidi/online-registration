package com.registrationonline.customerregistration.controller;

import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.service.ApplicantService;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ApplicantControllerTest
{
	@MockBean
	private ApplicantService applicantService;

	Applicant mockApplicant = new Applicant(8011255834187l,"David","Doe");
	//passed
	@Test
	public void getAllApplicantsTest(){
		List<Applicant> list = new ArrayList<>();
		Applicant applicant1 = new Applicant(3456l,"Joe","Doe");
		Applicant applicant2 = new Applicant(3457l,"Goe","Hyu");
		Applicant applicant3 = new Applicant(3458l,"Iue","Jue");
		Applicant applicant4 = new Applicant(3459l,"Man","Jue");

		list.add( applicant1 );
		list.add( applicant2 );
		list.add( applicant3 );
		list.add( applicant4 );


		when(applicantService.getAllApplicants()).thenReturn( list );

		List<Applicant> applicantList = applicantService.getAllApplicants();
		assertEquals( 4,applicantList.size() );
		verify( applicantService, times( 1 ) ).getAllApplicants();
		var found = applicantList.stream().filter(applicant -> "Jue".equals( applicant.getLastName() ) && "Man".equals(applicant.getFirstName())).count() > 0;
		assertThat(found).isTrue();
	}

	//passed
	@Test
	public void getApplicantByIdTest(){
		when(applicantService.findApplicantById( 8011255834187l )).thenReturn( mockApplicant );
		Applicant applicant = applicantService.findApplicantById( 8011255834187l );
		assertEquals( "David",applicant.getFirstName() );
		assertEquals( "Doe",applicant.getLastName() );

	}

	@Test
	public void createApplicantTest(){
		Applicant applicant = new Applicant(8011255834187l,"David","Doe");
		applicantService.saveApplicant( applicant );
		verify(applicantService, times( 1)).saveApplicant( applicant );
	}

}
