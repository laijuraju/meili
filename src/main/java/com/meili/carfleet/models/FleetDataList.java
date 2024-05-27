package com.meili.carfleet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author LAIJU
 *
 *This file typically contains data and attributes associated with vehicles,their specifications,
 *and other pertinent details relevant to fleet management.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FleetDataList {
    private List<Fleet> fleet;
}
