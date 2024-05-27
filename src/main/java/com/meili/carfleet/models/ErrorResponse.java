/**
 * 
 */
package com.meili.carfleet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LAIJU Global error response for the service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private String statusCode;
	private String message;
}
