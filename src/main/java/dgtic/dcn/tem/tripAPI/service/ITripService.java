package dgtic.dcn.tem.tripAPI.service;

import java.util.List;
import java.util.Optional;

import dgtic.dcn.tem.tripAPI.model.Trip;


public interface ITripService {
	
	List<Trip> findAllTrips();
	
	Optional<Trip> findTripById(String id);
	
	Trip saveTrip (Trip trip);

	Trip updateTrip(String idTrip, Trip trip);
}
