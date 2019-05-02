package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.Device;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    Device toDevice(DeviceDto deviceDto);

    DeviceDto toDeviceDto(Device device);

    List<DeviceDto> toDeviceDtos(List<Device> devicesList);
}
