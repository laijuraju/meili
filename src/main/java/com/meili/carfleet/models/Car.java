/**
 * 
 */
package com.meili.carfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Car {

	private String name;
	private String transmissionType;
	private RentalCostPerDay rentalCostPerDay;
	@JsonProperty(value="isElectric")
	private boolean isElectric;
	@JsonProperty(value="isDiesel")
	private boolean isDiesel;
	@JsonProperty(value="isPetrol")
	private boolean isPetrol;

}
