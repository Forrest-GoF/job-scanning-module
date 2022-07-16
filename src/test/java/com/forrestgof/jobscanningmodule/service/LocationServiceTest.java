package com.forrestgof.jobscanningmodule.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.Location;
import com.forrestgof.jobscanningmodule.repository.LocationRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class LocationServiceTest {

	@Autowired
	LocationService locationService;
	@Autowired
	LocationRepository locationRepository;

	@Test
	public void 지역저장() throws Exception {
		//given
		Location location = Location.from("경기도 용인시");

		//when
		Long id = locationService.save(location);

		//then
		org.assertj.core.api.Assertions.assertThat(location).isEqualTo(locationRepository.findById(id).get());
	}
}
