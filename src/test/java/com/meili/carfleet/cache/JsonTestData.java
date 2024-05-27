package com.meili.carfleet.cache;

import java.util.Arrays;
import java.util.List;

import com.meili.carfleet.models.Car;
import com.meili.carfleet.models.CarTypeDetailsList;
import com.meili.carfleet.models.Fleet;
import com.meili.carfleet.models.FleetDataList;

public class JsonTestData {

	public static List<FleetDataList> getExpectedFleetDataList() {
		FleetDataList fleetDataList = new FleetDataList();
		fleetDataList.setFleet(Arrays.asList(new Fleet("Renault", "Captur", true, "petrol", 1234.22),
				new Fleet("Renault", "Volvo S60", false, "diesel", 1744.66),
				new Fleet("Hyundai", "Ioniq", true, "electric", 2098.34)));
		return Arrays.asList(fleetDataList);
	}
//
//	public static List<CarTypeDetailsList> getExpectedCarDetailsList() {
//        CarTypeDetailsList carTypeDetailsList = new CarTypeDetailsList();
//        carTypeDetailsList.setCars(Arrays.asList(
//                new Car("Skoda Octavia", "manual", 10.23, 40.87, false, false, true),
//                createCarDetails("BMW 3 Series", "automatic", 30.1, 90.33, true, true, false)
//        ));
//        return Arrays.asList(carTypeDetailsList);
//    }

    
}
