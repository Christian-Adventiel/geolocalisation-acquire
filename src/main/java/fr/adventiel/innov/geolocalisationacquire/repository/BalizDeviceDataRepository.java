package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDeviceData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * {@link BalizDeviceData} repository
 * Created by Anto on 03/05/19.
 */
public interface BalizDeviceDataRepository extends MongoRepository<BalizDeviceData, String> {
    List<BalizDeviceData> findByDeviceId(String deviceId);
}
