/**
 *
 */
package com.meili.carfleet.models.api.response;

import java.util.List;

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
public class FleetResponseBody {
    private String statusCode;
	private String status;
    private List<Object> response;

}
