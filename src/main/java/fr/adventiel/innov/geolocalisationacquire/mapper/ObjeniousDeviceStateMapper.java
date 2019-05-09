package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDeviceState;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceStateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjeniousDeviceStateMapper {
    ObjeniousDeviceState toDeviceState(ObjeniousDeviceStateDto objeniousDeviceStateDto);

    ObjeniousDeviceStateDto toDeviceStateDto(ObjeniousDeviceState objeniousDeviceState);
}
