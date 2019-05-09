package fr.adventiel.innov.geolocalisationacquire.controller;

import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDataDto;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceLocationDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceStateDto;
import fr.adventiel.innov.geolocalisationacquire.mapper.*;
import fr.adventiel.innov.geolocalisationacquire.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for all devices
 */
@RestController(value = "/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final ObjeniousDeviceStateRepository objeniousDeviceStateRepository;
    private final ObjeniousDeviceLocationRepository objeniousDeviceLocationRepository;
    private final ObjeniousDeviceMapper objeniousDeviceMapper;
    private final ObjeniousDeviceStateMapper objeniousDeviceStateMapper;
    private final ObjeniousDeviceLocationMapper objeniousDeviceLocationMapper;
    private final ObjeniousDeviceRepository objeniousDeviceRepository;

    private final BalizDeviceRepository balizDeviceRepository;
    private final BalizDeviceDataRepository balizDeviceDataRepository;
    private final BalizDeviceMapper balizDeviceMapper;
    private final BalizDeviceDataMapper balizDeviceDataMapper;

    @CrossOrigin
    @GetMapping("/objenious")
    List<ObjeniousDeviceDto> findAllObjenious() {
        return objeniousDeviceMapper.toDeviceDtos(objeniousDeviceRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/objenious/{deviceId}/locations")
    List<ObjeniousDeviceLocationDto> getObjeniousLocations(@RequestParam String deviceId) {
        return objeniousDeviceLocationMapper.toDeviceLocationDtos(objeniousDeviceLocationRepository.findByDeviceId(deviceId));
    }

    @CrossOrigin
    @GetMapping("/objenious/{deviceId}/state")
    ObjeniousDeviceStateDto getObjeniousDeviceState(@PathVariable final String deviceId) {
        return objeniousDeviceStateMapper.toDeviceStateDto(this.objeniousDeviceStateRepository.findById(deviceId));
    }

    @CrossOrigin
    @GetMapping("/baliz")
    List<BalizDeviceDto> findAllBaliz() {
        return balizDeviceMapper.toBalizDeviceDtos(balizDeviceRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/baliz/{deviceId}/data")
    BalizDeviceDataDto getBalizData(@PathVariable final String deviceId) {
        return balizDeviceDataMapper.toBalizDeviceDataDto(balizDeviceDataRepository.findById(deviceId));
    }
}
