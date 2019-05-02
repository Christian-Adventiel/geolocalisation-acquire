package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.DeviceLocation;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceLocationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceLocationMapper {
    DeviceLocation toDeviceLocation(DeviceLocationDto deviceLocationDto);
    List<DeviceLocationDto> toDeviceLocationDtos(List<DeviceLocation> deviceLocations);
}
