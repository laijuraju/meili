/**
 *
 */
package com.meili.carfleet.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meili.carfleet.cache.CarFleetCacheService;
import com.meili.carfleet.exception.NoRecordFoundException;
import com.meili.carfleet.models.api.response.FleetResponseBody;

import lombok.RequiredArgsConstructor;

/**
 * @author LAIJU 
 * Implementation of a service dedicated to the management of car
 *         fleet details. This service amalgamates both fleet and car details
 *         into a unified format.
 */
@Service
@RequiredArgsConstructor
public class FleetServiceImpl implements CarFleetService {

	@Autowired
	private CarFleetCacheService carFleetCacheService;

	private FleetResponseBody fleetResponseBody;

	@Override
	public FleetResponseBody getAllCarDetails() {
		fleetResponseBody = new FleetResponseBody();
		List<Object> combined = Stream.concat(carFleetCacheService.getFleetDataList().stream(),
				carFleetCacheService.getCarDetailsList().stream()).collect(Collectors.toList());
		if (combined == null || combined.size() == 0) {
			throw new NoRecordFoundException();
		}
		fleetResponseBody.setResponse(combined);
		return fleetResponseBody;
	}

}
