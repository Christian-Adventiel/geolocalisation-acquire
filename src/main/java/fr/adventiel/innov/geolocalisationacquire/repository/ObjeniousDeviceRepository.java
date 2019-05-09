package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDevice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjeniousDeviceRepository extends MongoRepository<ObjeniousDevice, Long> {
}
