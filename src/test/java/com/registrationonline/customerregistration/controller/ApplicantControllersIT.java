package com.registrationonline.customerregistration.controller;

import com.registrationonline.customerregistration.OnlineRegistrationApplication;
import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.service.ApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OnlineRegistrationApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ApplicantControllersIT
{
	private final HttpHeaders httpHeaders = new HttpHeaders();

	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	ApplicantService applicantService;
	@Autowired

	@LocalServerPort
	private int port;
	@Test
	public void givenCorrectApplicantIdCheckIfCorrectDetailsAreRetrieved(){
		long id = 7811265834187l;
		HttpEntity<Applicant> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Applicant> applicantResponseEntity;
		applicantResponseEntity = testRestTemplate.exchange(createURLWithPort("/applicants/"+id),
				HttpMethod.GET,
				entity,
				Applicant.class);
		String expectedFirstname = "Sabre";
		assertNotNull(applicantResponseEntity);
		assertEquals(expectedFirstname,applicantResponseEntity.getBody().getFirstName());
	}

	@Test
	public void givenInCorrectApplicantIdCheck_NoResultsRetrieved(){
		long id = 7811265834188l;
		HttpEntity<Applicant> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Applicant> applicantResponseEntity;
		applicantResponseEntity = testRestTemplate.exchange(createURLWithPort("/applicants/"+id),
				HttpMethod.GET,
				entity,
				Applicant.class);
		String expectedFirstname = "Sabre";
		assertNotNull(applicantResponseEntity);
		assertNotEquals(expectedFirstname,applicantResponseEntity.getBody().getFirstName());
	}

	@Test
	public void givenCorrectAddressDeatilsCheckIfCorrectDetailsAreCreated(){
		Applicant applicant = new Applicant();
		applicant.setId( 7902225834187l);
		applicant.setFirstName( "Johan" );
		applicant.setLastName( "Smith" );
		HttpEntity<Applicant> entity = new HttpEntity<>(applicant, httpHeaders);
		ResponseEntity<String> applicantResponseEntity;
		applicantResponseEntity = testRestTemplate.exchange(createURLWithPort("/addapplicant"),
				HttpMethod.POST,
				entity,
				String.class);
		String expectedFirstName = "Johan";
		assertNotNull(applicantResponseEntity);
		assertNotNull(applicantResponseEntity.getBody());
		//assertEquals(expectedSurburb,addressResponseEntity.getBody());
	}


	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/registrationapi" + uri ;
	}
}

