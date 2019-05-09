package fr.adventiel.innov.geolocalisationacquire.repository;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDevice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * {@link BalizDevice} repository
 * Created by Anto on 03/05/19.
 */
public interface BalizDeviceRepository extends MongoRepository<BalizDevice, Long> {}
