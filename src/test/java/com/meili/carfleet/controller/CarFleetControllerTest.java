/**
 * @author LAIJU
 */
package com.meili.carfleet.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.meili.carfleet.models.Car;
import com.meili.carfleet.models.RentalCostPerDay;
import com.meili.carfleet.models.api.response.FleetResponseBody;
import com.meili.carfleet.service.CarFleetService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarFleetControllerTest {

    @Mock
    private CarFleetService carService;

    @InjectMocks
    private CarFleetController carFleetController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCarDetailsSuccess() {
        // Mock data
    	RentalCostPerDay mockCostPerDay = new RentalCostPerDay(120.00, 400.00);
    	Car mockCars = new Car("Toyota", "Camry", mockCostPerDay, false, false, true);
        FleetResponseBody mockResponseBody = new FleetResponseBody();
        mockResponseBody.setStatus("OK");
        mockResponseBody.setStatusCode("200");
        mockResponseBody.setResponse(List.of(mockCars));

        // Mock service behavior
        when(carService.getAllCarDetails()).thenReturn(mockResponseBody);

        // Test the controller method
        ResponseEntity<FleetResponseBody> responseEntity = carFleetController.getAllCarDetails("authHeader", "apiVersion");

        // Verify the response
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponseBody, responseEntity.getBody());
    }

    @Test
    void testGetAllCarDetailsEmptyResponse() {
        // Mock data
        FleetResponseBody mockResponseBody = new FleetResponseBody();
        mockResponseBody.setResponse(new ArrayList<Object>());
        mockResponseBody.setStatus("Failed");
		mockResponseBody.setStatusCode("400");
        // Mock service behavior
        when(carService.getAllCarDetails()).thenReturn(mockResponseBody);

        // Test the controller method
        ResponseEntity<FleetResponseBody> responseEntity = carFleetController.getAllCarDetails("authHeader", "apiVersion");

        // Verify the response
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Failed", responseEntity.getBody().getStatus());
        assertEquals("404", responseEntity.getBody().getStatusCode());
    }

    @Test
    void testGetAllCarDetailsExceptionHandling() {
        // Mock service behavior to throw an exception
        when(carService.getAllCarDetails()).thenThrow(new RuntimeException("exception"));

        // Test the controller method
        ResponseEntity<FleetResponseBody> responseEntity = carFleetController.getAllCarDetails("authHeader", "apiVersion");

        // Verify the response
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Failed", responseEntity.getBody().getStatus());
        assertEquals("404", responseEntity.getBody().getStatusCode());
    }}
