package com.meili.carfleet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author LAIJU
 * This attribute serves to define and provide information about the particular category
 * or classification of the vehicle as outlined in the JSON file.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarTypeDetailsList {
    private List<Car> cars;
}
