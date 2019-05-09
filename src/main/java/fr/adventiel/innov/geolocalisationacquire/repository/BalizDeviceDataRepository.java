package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDeviceData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * {@link BalizDeviceData} repository
 * Created by Anto on 03/05/19.
 */
public interface BalizDeviceDataRepository extends MongoRepository<BalizDeviceData, Long> {
    BalizDeviceData findById(String id);
}
