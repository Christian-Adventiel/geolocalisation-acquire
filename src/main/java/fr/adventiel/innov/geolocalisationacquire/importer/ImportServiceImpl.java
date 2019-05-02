package fr.adventiel.innov.geolocalisationacquire.importer;

import fr.adventiel.innov.geolocalisationacquire.domain.Device;
import fr.adventiel.innov.geolocalisationacquire.domain.DeviceLocation;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DeviceLocationWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.DevicesStatesWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceLocationMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceMapper;
import fr.adventiel.innov.geolocalisationacquire.mapper.DeviceStateMapper;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceLocationRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceRepository;
import fr.adventiel.innov.geolocalisationacquire.repository.DeviceStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {
    private final RestTemplate restTemplate;
    private final DeviceRepository deviceRepository;
    private final DeviceStateRepository deviceStateRepository;
    private final DeviceLocationRepository deviceLocationRepository;
    private final DeviceMapper deviceMapper;
    private final DeviceStateMapper deviceStateMapper;
    private final DeviceLocationMapper deviceLocationMapper;

    @Value(value = "${objenious.enpoints.devices}")
    private String devicesUrl;
    @Value(value = "${objenious.enpoints.devicesStates}")
    private String devicesStatesUrl;
    @Value(value = "${objenious.enpoints.deviceLocation}")
    private String deviceLocationUrl;

    @Override
    public void doImport() {
        importDevice();
        importDevicesStates();
        importDevicesLocations();
    }

    /**
     * Import devices from Objenious to MongoDB.
     */
    private void importDevice() {
        ResponseEntity<List<DeviceDto>> deviceDtoResponse = restTemplate.exchange(devicesUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<DeviceDto>>() {});

        deviceDtoResponse.getBody().forEach(
                deviceDto -> deviceRepository.save(deviceMapper.toDevice(deviceDto))
        );
    }

    /**
     * Import devices states. One state per device, as per the API.
     */
    private void importDevicesStates() {
        List<Device> devices = deviceRepository.findAll();

        String devicesListString = devices.stream().map(device -> device.getId()).collect(Collectors.joining( "," ));

        UriComponentsBuilder builder = UriComponentsBuilder
        .fromUriString(devicesStatesUrl)
        .queryParam("id", devicesListString);

        DevicesStatesWrapperDto devicesStatesWrapperDto = restTemplate.getForObject(builder.toUriString(), DevicesStatesWrapperDto.class);

        devicesStatesWrapperDto.getStates().forEach(
                deviceStateDto -> deviceStateRepository.save(deviceStateMapper.toDeviceState(deviceStateDto))
        );
    }

    /**
     * Import devices locations history. Objenious only keeps the last 10 locations.
     */
    private void importDevicesLocations() {
        List<Device> devices = deviceRepository.findAll();
        devices.forEach(
                device -> {
                    DeviceLocationWrapperDto deviceLocationWrapperDto = restTemplate.getForObject(MessageFormat.format(deviceLocationUrl, device.getId()), DeviceLocationWrapperDto.class);

                    deviceLocationWrapperDto.getLocations().forEach(
                            deviceLocationDto -> {
                                if (deviceLocationRepository.findByTimestampAndDeviceId(deviceLocationDto.getTimestamp(), device.getId()) == null) {
                                    DeviceLocation deviceLocation = deviceLocationMapper.toDeviceLocation(deviceLocationDto);
                                    deviceLocation.setDeviceId(device.getId());
                                    deviceLocationRepository.save(deviceLocation);
                                }
                            }
                    );
                }
        );
    }
}
