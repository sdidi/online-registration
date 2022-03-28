package com.registrationonline.customerregistration.service;

import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.repository.ApplicantRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ApplicantServiceTest
{
	@Autowired
	ApplicantService applicantService;
	@MockBean
	ApplicantRepository applicantRepository;

	@Test
	public void whenIdIsProvided_returnCorrectApplicant() throws Exception
	{
		Applicant applicant =  new Applicant(8011165800086l,"David","Doe");
		doReturn( Optional.of( applicant)).when( applicantRepository).findById( 8011165800086l );
		Applicant applicantFound = applicantService.findApplicantById( 8011165800086l );
		assertEquals( "David" ,applicantFound.getFirstName());
	}

	@Test
	public void testCreateApplicant_usingMock(){
		Applicant applicant =  new Applicant(8011165800086l,"David","Doe");
		applicantRepository.save( applicant );
		verify(applicantRepository, times( 1)).save( applicant );
	}

}
