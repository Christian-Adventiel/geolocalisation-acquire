package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDeviceData;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDataDto;

/**
 * Created by Anto on 03/05/19.
 */
public interface BalizDeviceDataMapper {

    BalizDeviceData toBalizDeviceData(BalizDeviceDataDto balizDeviceDataDto);

    BalizDeviceDataDto toBalizDeviceDataDto(BalizDeviceData balizDeviceData);
}
