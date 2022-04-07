package com.registrationonline.customerregistration.service;

import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.errorhandling.ResourceNotFoundException;
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
		log.info( "This method takes an Id and returns the applicant with id "+id );
		Applicant applicant = null;
		try
		{
			applicant = applicantRepository.findById( id )
					.orElseThrow( () -> new ResourceNotFoundException( "Applicant not found with id = " + id ) );
		}
		catch(ResourceNotFoundException rs){
			log.info( rs.getMessage() );
		}
		return applicant;
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
		Applicant currentApplicant = null;
		try
		{
			applicantRepository.findById( id )
					.orElseThrow( () -> new ResourceNotFoundException( "Applicant not found with id= " + id ) );
			currentApplicant.setFirstName( applicant.getFirstName() );
			currentApplicant.setLastName( applicant.getLastName() );
			return applicantRepository.save( currentApplicant );
			}
		catch(ResourceNotFoundException rnf){
			log.info( rnf.getMessage() );
		}
		return currentApplicant;
	}

	@Override
	public String deleteApplicant( Long id )
	{
		log.info( "This method deletes an applicant identified by an id" );
		applicantRepository.deleteById( id );
		return "success";
	}
}
