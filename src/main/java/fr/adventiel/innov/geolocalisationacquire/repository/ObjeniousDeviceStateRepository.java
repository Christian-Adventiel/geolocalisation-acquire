package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDeviceState;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjeniousDeviceStateRepository extends MongoRepository<ObjeniousDeviceState, Integer> {
    ObjeniousDeviceState findById(String deviceId);
}
