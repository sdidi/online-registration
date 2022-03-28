package com.registrationonline.customerregistration.controller;

import com.registrationonline.customerregistration.domain.Applicant;
import com.registrationonline.customerregistration.service.ApplicantService;
import io.swagger.annotations.*;
import java.net.*;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/registrationapi")
@Slf4j
public class ApplicantController
{
	@Autowired
	ApplicantService applicantService;

	@GetMapping("/applicants")
	@ApiOperation(  value = " Find all the applicants in the database",
			notes= " This displays all the applicants in the database",
			response = List.class)
	public List<Applicant> getApplicants(){
		log.info( "This method returns all the applicants" );
		return applicantService.getAllApplicants();
	}

	@GetMapping("/applicants/{id}")
	@ApiOperation( value =" Looks up a specific applicant by the id",
			notes = " Provides an id to look up a specific applicant from the database",
			response = Applicant.class)
	public Applicant getApplicant(@ApiParam(value =" An Id you need to retrieve the Applicant", required = true)
			@PathVariable Long id) throws Exception
	{
		log.info( "This method gets the applicant with id: "+id );
		return applicantService.findApplicantById( id );
	}

	@PostMapping("/addapplicant")
	@ApiOperation( value =" Registers a new applicant",
			notes = " Creates an applicant and save on the database ",
			response = Applicant.class)
	public ResponseEntity createApplicant(@RequestBody Applicant applicant) throws URISyntaxException
	{
		log.info( "This method saves a new applicant with id: "+applicant.getId());
		Applicant currentApplicant = applicantService.saveApplicant( applicant );
		return  ResponseEntity.created( new URI("/registrationapi/"+currentApplicant.getId()) )
				.body( currentApplicant );
	}

	@PutMapping("/editapplicant/{id}")
	@ApiOperation( value =" Updates an existing applicant",
			notes = " Updates an existing applicant and save in the database ",
			response = Applicant.class)
	public ResponseEntity updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant) throws Exception
	{
		log.info( "This method updates the applicant with id: "+id );
		Applicant currentApplicant = applicantService.updateApplicant( applicant, id );
		return ResponseEntity.ok(currentApplicant);
	}

	@DeleteMapping("deleteapplicant/{id}")
	@ApiOperation( value =" deletes an applicant",
			notes = " Deletes a specific applicant identified with the id ",
			response = Applicant.class)
	public ResponseEntity deleteApplicant(@PathVariable Long id){
		log.info( "This method deletes an applicant with id: "+id);
		applicantService.deleteApplicant( id );
		return ResponseEntity.ok().build();
	}
}
