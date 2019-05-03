package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDeviceLocation;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceLocationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjeniousDeviceLocationMapper {
    ObjeniousDeviceLocation toDeviceLocation(ObjeniousDeviceLocationDto objeniousDeviceLocationDto);
    List<ObjeniousDeviceLocationDto> toDeviceLocationDtos(List<ObjeniousDeviceLocation> objeniousDeviceLocations);
}
