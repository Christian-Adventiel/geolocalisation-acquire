package fr.adventiel.innov.geolocalisationacquire.controller;

import fr.adventiel.innov.geolocalisationacquire.dto.DeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceLocationDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceStateDto;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceLocationMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceStateMapper;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceLocationRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/device")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceStateRepository deviceStateRepository;
    private final DeviceLocationRepository deviceLocationRepository;
    private final DeviceMapper deviceMapper;
    private final DeviceStateMapper deviceStateMapper;
    private final DeviceLocationMapper deviceLocationMapper;
    private final DeviceRepository deviceRepository;

    @CrossOrigin
    @GetMapping("/devices")
    List<DeviceDto> findAll() {
        return deviceMapper.toDeviceDtos(deviceRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/device/{deviceId}/locations")
    List<DeviceLocationDto> getLocations(@RequestParam Long deviceId) {
        return deviceLocationMapper.toDeviceLocationDtos(deviceLocationRepository.findByDeviceId(deviceId));
    }

    @CrossOrigin
    @GetMapping("/device/{deviceId}/state")
    DeviceStateDto getDeviceState(@PathVariable final Long deviceId) {
        return deviceStateMapper.toDeviceStateDto(this.deviceStateRepository.findById(deviceId));
    }
}
