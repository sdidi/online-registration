package com.registrationonline.customerregistration.repository;

import com.registrationonline.customerregistration.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long>
{
}
