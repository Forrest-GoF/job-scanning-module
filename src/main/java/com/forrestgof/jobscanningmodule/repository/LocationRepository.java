package com.forrestgof.jobscanningmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forrestgof.jobscanningmodule.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}

