package com.forrestgof.jobscanningmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forrestgof.jobscanningmodule.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
