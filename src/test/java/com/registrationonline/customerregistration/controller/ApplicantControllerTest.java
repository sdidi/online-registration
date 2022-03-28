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

	Applicant mockApplicant = new Applicant(8011165800086l,"David","Doe");
	//passed
	@Test
	public void getAllApplicantsTest(){
		List<Applicant> list = new ArrayList<>();
		Applicant applicant1 = new Applicant(7701014800086l,"Joe","Doe");
		Applicant applicant2 = new Applicant(7707014800083l,"Goe","Hyu");
		Applicant applicant3 = new Applicant(6905124800081l,"Iue","Jue");
		Applicant applicant4 = new Applicant(8410084800088l,"Man","Jue");

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
	public void getApplicantByIdTest() throws Exception
	{
		when(applicantService.findApplicantById( 8011165800086l )).thenReturn( mockApplicant );
		Applicant applicant = applicantService.findApplicantById( 8011165800086l );
		assertEquals( "David",applicant.getFirstName() );
		assertEquals( "Doe",applicant.getLastName() );

	}

	@Test
	public void createApplicantTest(){
		Applicant applicant = new Applicant(7701014800086l,"David","Doe");
		applicantService.saveApplicant( applicant );
		verify(applicantService, times( 1)).saveApplicant( applicant );
	}

}
