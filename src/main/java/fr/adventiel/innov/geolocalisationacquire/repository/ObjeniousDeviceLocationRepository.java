package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDeviceLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ObjeniousDeviceLocationRepository extends MongoRepository<ObjeniousDeviceLocation, Long> {
    ObjeniousDeviceLocation findByTimestampAndDeviceId(Date ts, String deviceId);

    List<ObjeniousDeviceLocation> findByDeviceId(String deviceId);
}
