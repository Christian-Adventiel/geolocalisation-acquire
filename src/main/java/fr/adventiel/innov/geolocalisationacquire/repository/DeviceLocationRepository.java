package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.DeviceLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface DeviceLocationRepository extends MongoRepository<DeviceLocation, Long> {
    DeviceLocation findByTimestampAndDeviceId(Date ts, String deviceId);

    List<DeviceLocation> findByDeviceId(String deviceId);
}
