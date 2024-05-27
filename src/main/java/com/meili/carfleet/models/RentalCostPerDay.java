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
public class RentalCostPerDay {
	private double tax;
	private double cost;
}
