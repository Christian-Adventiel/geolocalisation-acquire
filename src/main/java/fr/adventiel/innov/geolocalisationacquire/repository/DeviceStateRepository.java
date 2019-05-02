package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.DeviceState;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceStateRepository extends MongoRepository<DeviceState, Integer> {
    DeviceState findById(Long deviceId);
}
