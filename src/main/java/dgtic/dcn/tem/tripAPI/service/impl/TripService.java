package dgtic.dcn.tem.tripAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgtic.dcn.tem.tripAPI.model.Trip;
import dgtic.dcn.tem.tripAPI.repository.TripRepository;
import dgtic.dcn.tem.tripAPI.service.ITripService;

@Service
public class TripService implements ITripService {
	
	@Autowired
	private TripRepository repository; 

	@Override
	public List<Trip> findAllTrips() {
		return repository.findAll();
	}

	@Override
	public Optional<Trip> findTripById(String id) {
		return repository.findById(id);
	}

	@Override
	public Trip saveTrip(Trip trip) {		
		return repository.save(trip);
	}

	@Override
	public Trip updateTrip(String idTrip, Trip trip) {
		Optional<Trip> oldTrip = repository.findById(idTrip);
		
		if (oldTrip.isPresent()) {
			//Trip estadoActualizar = estadoExistente.get();
			//estadoActualizar.setNombre(estado.getNombre());
			//estadoRepository.save(estadoActualizar);
			repository.save(trip);
			return trip;
		}
		
		return null;
	} 
}
