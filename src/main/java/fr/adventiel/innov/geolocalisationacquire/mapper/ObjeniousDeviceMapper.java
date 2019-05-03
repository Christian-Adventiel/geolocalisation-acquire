package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDevice;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjeniousDeviceMapper {
    ObjeniousDevice toDevice(ObjeniousDeviceDto objeniousDeviceDto);

    ObjeniousDeviceDto toDeviceDto(ObjeniousDevice objeniousDevice);

    List<ObjeniousDeviceDto> toDeviceDtos(List<ObjeniousDevice> devicesList);
}
