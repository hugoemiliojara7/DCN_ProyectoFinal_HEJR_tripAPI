package dgtic.dcn.tem.tripAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import dgtic.dcn.tem.tripAPI.model.Trip;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(path="api/v1/trips", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="trips", description="EndPoint of trip resource")
public interface TripApi {

	@Operation(summary = "Get all trips saved in collection")
	@ApiResponse(responseCode = "200", description = "Trips retrieved successfully", 
				content = {@Content(mediaType="application/json", 
				schema = @Schema(implementation = Trip.class))})
	@GetMapping
	List<Trip> getAllTrips();
	
	@Operation(summary = "Get a specific trip by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trip retrieved successfully",
					content = {@Content(mediaType="application/json", 
							schema = @Schema(implementation = Trip.class))}), 
			@ApiResponse(responseCode = "404", description = "Trip not found",
			content = @Content)
	})	
	@GetMapping("{idTrip}")
	ResponseEntity<Trip> getTripById(@PathVariable("idTrip") String idTrip);
	
	@Operation(summary = "Save a new trip")
	@ApiResponse(responseCode = "201", description = "Trip saved successfully",
			content = {@Content(mediaType="application/json", 
			schema = @Schema(implementation=Trip.class))} )
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Trip saveTrip(@RequestBody Trip trip);
	
	@Operation(summary = "Update trip information or details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trip updated successfully",
					content = {@Content(mediaType="application/json", 
						schema = @Schema(implementation=Trip.class))}), 
			@ApiResponse(responseCode = "404", description = "Trip not found",
			content = @Content)
	})
	@PutMapping(path="{idTrip}", consumes="application/json")
	ResponseEntity<Trip> updateTrip(@PathVariable("idTrip") String idTrip, 
			@RequestBody Trip trip);
}
