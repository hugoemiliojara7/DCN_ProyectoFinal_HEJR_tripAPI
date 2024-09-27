package dgtic.dcn.tem.tripAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dgtic.dcn.tem.tripAPI.model.Trip;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

}
