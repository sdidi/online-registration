package com.registrationonline.customerregistration.service;

import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.repository.ApplicantRepository;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicantServiceImpl implements  ApplicantService
{
	@Autowired
	private ApplicantRepository applicantRepository;
	@Override
	public Applicant findApplicantById( Long id )
	{
		log.info( "This method takes an Id and returns the applicant" );
		return applicantRepository.findById( id ).get();
	}

	@Override
	public List<Applicant> getAllApplicants()
	{
		log.info( "This method returns all the applicants in the database" );
		return applicantRepository.findAll();
	}

	@Override
	public Applicant saveApplicant( Applicant applicant )
	{
		log.info( "This method saves the applicant" );
		return applicantRepository.save( applicant );
	}

	@Override
	public Applicant updateApplicant( Applicant applicant, Long id )
	{
		log.info( "This method updates the fields of an applicant" );
		Applicant currentApplicant = applicantRepository.findById( id ).orElseThrow();
		currentApplicant.setFirstName( applicant.getFirstName() );
		currentApplicant.setLastName( applicant.getLastName() );
		return applicantRepository.save( currentApplicant );
	}

	@Override
	public String deleteApplicant( Long id )
	{
		log.info( "This method deletes an applicant identified by an id" );
		applicantRepository.deleteById( id );
		return "success";
	}
}
