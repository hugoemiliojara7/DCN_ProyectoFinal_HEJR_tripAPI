package dgtic.dcn.tem.tripAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dgtic.dcn.tem.tripAPI.model.Trip;
import dgtic.dcn.tem.tripAPI.service.ITripService;

@RestController
public class TripController implements TripApi {
	
	@Autowired
	private ITripService service; 

	@Override
	public List<Trip> getAllTrips() {
		return service.findAllTrips();
	}

	@Override
	public ResponseEntity<Trip> getTripById(String idTrip) {	
		Optional<Trip> trip = service.findTripById(idTrip);
		
		if(trip.isPresent())
			return new ResponseEntity<>(trip.get(), HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	public Trip saveTrip(Trip trip) {		
		return service.saveTrip(trip);
	}

	@Override
	public ResponseEntity<Trip> updateTrip(String idTrip, Trip trip) {
		Trip updatedTrip = service.updateTrip(idTrip, trip);
		
		if (updatedTrip != null) {
			return new ResponseEntity<>(updatedTrip, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	} 

}
