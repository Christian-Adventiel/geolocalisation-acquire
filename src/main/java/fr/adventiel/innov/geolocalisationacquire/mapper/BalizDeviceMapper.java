package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDevice;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Anto on 03/05/19.
 */
@Mapper(componentModel = "spring")
public interface BalizDeviceMapper {

    BalizDevice toBalizDevice(BalizDeviceDto balizDeviceDto);

    List<BalizDeviceDto> toBalizDeviceDtos(List<BalizDevice> balizDevices);
}
