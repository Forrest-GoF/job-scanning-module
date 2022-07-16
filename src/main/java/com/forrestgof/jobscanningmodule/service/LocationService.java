package com.forrestgof.jobscanningmodule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.Location;
import com.forrestgof.jobscanningmodule.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LocationService {

	private final LocationRepository locationRepository;

	@Transactional
	public Long save(Location location) {
		locationRepository.save(location);
		return location.getId();
	}

	public Location findOne(Long id) {
		return locationRepository.findById(id).orElseThrow();
	}

	public List<Location> findAll() {
		return locationRepository.findAll();
	}
}
