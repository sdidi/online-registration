package com.registrationonline.customerregistration.service;

import com.registrationonline.customerregistration.domain.Applicant;
import java.util.*;

public interface ApplicantService
{
	Applicant findApplicantById(Long id);
	List<Applicant> getAllApplicants();
	Applicant saveApplicant(Applicant applicant);
	Applicant updateApplicant(Applicant applicant, Long id);
	String deleteApplicant(Long id);

}
