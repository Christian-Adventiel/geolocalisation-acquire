package fr.adventiel.innov.geolocalisationacquire.controller;

import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceLocationDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceStateDto;
import fr.adventiel.innov.geolocalisationacquire.mapper.ObjeniousDeviceLocationMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.ObjeniousDeviceMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.ObjeniousDeviceStateMapper;
import fr.adventiel.innov.geolocalisationacquire.repository.ObjeniousDeviceLocationRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.ObjeniousDeviceRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.ObjeniousDeviceStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/device")
@RequiredArgsConstructor
public class ObjeniousDeviceController {
    private final ObjeniousDeviceStateRepository objeniousDeviceStateRepository;
    private final ObjeniousDeviceLocationRepository objeniousDeviceLocationRepository;
    private final ObjeniousDeviceMapper objeniousDeviceMapper;
    private final ObjeniousDeviceStateMapper objeniousDeviceStateMapper;
    private final ObjeniousDeviceLocationMapper objeniousDeviceLocationMapper;
    private final ObjeniousDeviceRepository objeniousDeviceRepository;

    @CrossOrigin
    @GetMapping("/devices")
    List<ObjeniousDeviceDto> findAll() {
        return objeniousDeviceMapper.toDeviceDtos(objeniousDeviceRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/device/{deviceId}/locations")
    List<ObjeniousDeviceLocationDto> getLocations(@RequestParam String deviceId) {
        return objeniousDeviceLocationMapper.toDeviceLocationDtos(objeniousDeviceLocationRepository.findByDeviceId(deviceId));
    }

    @CrossOrigin
    @GetMapping("/device/{deviceId}/state")
    ObjeniousDeviceStateDto getDeviceState(@PathVariable final String deviceId) {
        return objeniousDeviceStateMapper.toDeviceStateDto(this.objeniousDeviceStateRepository.findById(deviceId));
    }
}
