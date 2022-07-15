package com.forrestgof.jobscanningmodule.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.forrestgof.jobscanningmodule.domain.Location;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LocationRepository {

	private final EntityManager em;

	public void save(Location location) {
		em.persist(location);
	}

	public Location findOne(Long id) {
		return em.find(Location.class, id);
	}

	public List<Location> findAll() {
		return em.createQuery("select l from Location l", Location.class)
			.getResultList();
	}
}

