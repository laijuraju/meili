/**
 * 
 */
package com.meili.carfleet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meili.carfleet.models.api.response.FleetResponseBody;
import com.meili.carfleet.service.CarFleetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

/**
 * The primary controller for the Car Fleet Data Service, featuring a single GET
 * API for retrieving the unified response.
 * 
 * @author LAIJU
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Car fleet retrival APIs", description = "Activities associated with the management of a fleet.")
@RequiredArgsConstructor
public class CarFleetController {
	private static final Logger log = LoggerFactory.getLogger(CarFleetController.class);
	@Autowired
	private CarFleetService carFleetService;

	private FleetResponseBody responseBodyOfcarFleet = new FleetResponseBody();
	//Api call Uri definition
	@GetMapping("/details")
	@Operation(summary = "Retrieve a consolidated response containing comprehensive details about the car fleet.", description = "Obtains in-depth information regarding the fleet of cars.")
	public ResponseEntity<FleetResponseBody> getAllCarDetails(
			@RequestHeader(name = "authHeader") @NotBlank(message = "Authorization header is required") String authorizationHeader,
			@RequestHeader(name = "apiVersion") @NotBlank(message = "API Version is required") String customHeader) {
		try {
			//Invocation of the Car Fleet Service.
			responseBodyOfcarFleet = carFleetService.getAllCarDetails();
			if (responseBodyOfcarFleet != null && !responseBodyOfcarFleet.getResponse().isEmpty()) {
				responseBodyOfcarFleet.setStatusCode("200");
				responseBodyOfcarFleet.setStatus("OK");

			} else {
				responseBodyOfcarFleet = new FleetResponseBody();
				responseBodyOfcarFleet.setStatus("Failed");
				responseBodyOfcarFleet.setStatusCode("404");
			}

		} catch (Exception e) {
			log.error("An unexpected interruption has occurred during the API call. "
					+ "Kindly verify and address the issue accordingly.", e.getMessage());
			responseBodyOfcarFleet.setStatus("Failed");
			responseBodyOfcarFleet.setStatusCode("404");

		}
		return new ResponseEntity<>(responseBodyOfcarFleet, HttpStatus.OK);
	}

}
