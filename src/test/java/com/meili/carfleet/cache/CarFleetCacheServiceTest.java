package com.meili.carfleet.cache;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
/**
 * @author LAIJU
 * 
 * INCOMPLTE TEST CASES.
 */
		
class CarFleetCacheServiceTest {

    @Mock
    private InputStream fleetStream;

    @Mock
    private InputStream carDetailsStream;

    @InjectMocks
    private CarFleetCacheService carFleetCacheService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testGetFleetDataList() {
//        List<FleetDataList> expectedFleetDataList = JsonTestData.getExpectedFleetDataList();
//        when(carFleetCacheService.getFleetDataList()).thenReturn(expectedFleetDataList);
//        List<FleetDataList> result = carFleetCacheService.getFleetDataList();
//        assertEquals(expectedFleetDataList, result);
//    }

//    @Test
//    void testGetCarDetailsList() {
//        List<CarTypeDetailsList> expectedCarDetailsList = JsonTestData.getExpectedCarDetailsList();
//        when(carFleetCacheService.getCarDetailsList()).thenReturn(expectedCarDetailsList);
//        List<CarTypeDetailsList> result = carFleetCacheService.getCarDetailsList();
//        assertEquals(expectedCarDetailsList, result);
//    }
}
