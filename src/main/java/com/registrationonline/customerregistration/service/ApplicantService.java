package com.registrationonline.customerregistration.service;

import com.registrationonline.customerregistration.domain.Applicant;
import java.util.*;

public interface ApplicantService
{
	Applicant findApplicantById(Long id) throws Exception;
	List<Applicant> getAllApplicants();
	Applicant saveApplicant(Applicant applicant);
	Applicant updateApplicant(Applicant applicant, Long id) throws Exception;
	String deleteApplicant(Long id);

}
