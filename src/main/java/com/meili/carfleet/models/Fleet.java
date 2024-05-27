/**
 * 
 */
package com.meili.carfleet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LAIJU
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fleet {
	private String make;
	private String model;
	private boolean automaticTransmission;
	private String fuelType;
	private double weeklyRentalPrice;

}
