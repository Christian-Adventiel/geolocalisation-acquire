package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.DeviceState;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceStateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceStateMapper {
    DeviceState toDeviceState(DeviceStateDto deviceStateDto);

    DeviceStateDto toDeviceStateDto(DeviceState deviceState);
}
