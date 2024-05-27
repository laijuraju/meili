package com.meili.carfleet.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meili.carfleet.models.CarTypeDetailsList;
import com.meili.carfleet.models.FleetDataList;

import jakarta.annotation.PostConstruct;

/**
 * @author LAIJU This service class is responsible for defining the caching
 *         mechanism of Fleet Data JSON files into inline memory to facilitate
 *         expedited access.
 */
@Service
@CacheConfig(cacheNames = "carFleetCache")
public class CarFleetCacheService {
	// The designation of the Fleet JSON file's name attribute.
	@Value("${com.meili.carfleet.resource.path.json.fleet}")
	private String fleetJsonFile;
	// The designation of the Car JSON file's name attribute.
	@Value("${com.meili.carfleet.resource.path.json.cars}")
	private String carsJsonFile;

	private static final Logger log = LoggerFactory.getLogger(CarFleetCacheService.class);
	private final ObjectMapper objectMapper = new ObjectMapper();

	private List<FleetDataList> fleet;
	private List<CarTypeDetailsList> carsDetails;

	/**
	 * The aforementioned method is designed to execute within the initialization
	 * process, facilitating the loading of JSON files associated with the Fleet,
	 * specifically identified as "carsdata.json" and "fleetdata.json" within the
	 * resource directory. In the event of an error, the process will persist,
	 * logging an error along with its corresponding cause.
	 * 
	 */
	@PostConstruct
	public void initialize() {
		JsonFactory jsonFactory = objectMapper.getFactory();
		log.info("Startup - Caching Fleet JSON from Resource to Memory!");
		try (InputStream fleetStream = getClass().getResourceAsStream(fleetJsonFile);
				InputStream carDetailsStream = getClass().getResourceAsStream(carsJsonFile)) {
			if (fleetStream == null) {
				log.error("fleet json is null. Check if the resource path is correct.");
			} else {
				fleet = readJsonStream(fleetStream, FleetDataList.class, jsonFactory);
				log.debug("Fleet Json List : " + fleet.get(0).getFleet().toString());
			}

			if (carDetailsStream == null) {
				log.error("car json is null. Check if the resource path is correct.");
			} else {
				carsDetails = readJsonStream(carDetailsStream, CarTypeDetailsList.class, jsonFactory);
				log.debug("Car Json List : " + carsDetails.get(0).getCars().toString());
			}
			log.info("Ends - Caching Fleet JSON from Resource to Memory!");
		} catch (IOException e) {
			log.info("Interputed - Caching Fleet JSON from Resource to Memory!");
			log.error(
					"An unexpected interruption has occurred during the startup process. Kindly verify and address the issue accordingly.",
					e.getMessage());
		}
	}

	// Establishing cached data for subsequent retrieval.
	@Cacheable("cacheableFleetList")
	public List<FleetDataList> getFleetDataList() {
		return fleet;
	}

	@Cacheable("cacheableCarTypeDetailsList")
	public List<CarTypeDetailsList> getCarDetailsList() {
		return carsDetails;
	}

	/**
	 * The method is responsible for converting the JSON stream, deserializing each
	 * object individually.
	 * 
	 * @param <T>
	 * @param inputStream
	 * @param valueType
	 * @param jsonFactory - is used to create a JsonParser.
	 * @return
	 * @throws IOException
	 */
	private <T> List<T> readJsonStream(InputStream inputStream, Class<T> valueType, JsonFactory jsonFactory)
			throws IOException {
		List<T> result = new ArrayList<>();
		try (JsonParser jsonParser = jsonFactory.createParser(inputStream)) {
			while (jsonParser.nextToken() == JsonToken.START_OBJECT) {
				T entity = objectMapper.readValue(jsonParser, valueType);
				result.add(entity);
			}
		}
		return result;
	}
}
