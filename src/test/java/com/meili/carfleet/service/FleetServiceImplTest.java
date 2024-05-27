
package com.meili.carfleet.service;

import com.meili.carfleet.cache.CarFleetCacheService;
import com.meili.carfleet.models.CarTypeDetailsList;
import com.meili.carfleet.models.FleetDataList;
import com.meili.carfleet.models.api.response.FleetResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * @author LAIJU
 */
public class FleetServiceImplTest {


    @Mock
    private CarFleetCacheService cacheService;

    @InjectMocks
    private FleetServiceImpl fleetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCarDetails() {
        // Arrange
        List<FleetDataList> fleetDataList = Arrays.asList(new FleetDataList());
        List<CarTypeDetailsList> carDetailsList = Arrays.asList(new CarTypeDetailsList());

        when(cacheService.getFleetDataList()).thenReturn(fleetDataList);
        when(cacheService.getCarDetailsList()).thenReturn(carDetailsList);

        // Act
        FleetResponseBody result = fleetService.getAllCarDetails();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.getResponse().size()); // Combined size of fleetDataList and carDetailsList

        // Verify that the cacheService methods were called
        verify(cacheService, times(1)).getFleetDataList();
        verify(cacheService, times(1)).getCarDetailsList();
    }

}
