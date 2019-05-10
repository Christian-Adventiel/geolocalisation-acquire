package fr.adventiel.innov.geolocalisationacquire.importer;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDeviceData;
import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDevice;
import fr.adventiel.innov.geolocalisationacquire.domain.ObjeniousDeviceLocation;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDataWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDevicesWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDeviceLocationWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.dto.objenious.ObjeniousDevicesStatesWrapperDto;
import fr.adventiel.innov.geolocalisationacquire.mapper.*;
import fr.adventiel.innov.geolocalisationacquire.repository.*;
import fr.adventiel.innov.geolocalisationacquire.tools.RandomLocationGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("objeniousRestTemplate")
    private final RestTemplate objeniousRestTemplate;
    @Qualifier("balizRestTemplate")
    private final RestTemplate balizRestTemplate;

    private final ObjeniousDeviceRepository objeniousDeviceRepository;
    private final ObjeniousDeviceStateRepository objeniousDeviceStateRepository;
    private final ObjeniousDeviceLocationRepository objeniousDeviceLocationRepository;

    private final BalizDeviceRepository balizDeviceRepository;
    private final BalizDeviceDataRepository balizDeviceDataRepository;

    private final ObjeniousDeviceMapper objeniousDeviceMapper;
    private final ObjeniousDeviceStateMapper objeniousDeviceStateMapper;
    private final ObjeniousDeviceLocationMapper objeniousDeviceLocationMapper;

    private final BalizDeviceMapper balizDeviceMapper;
    private final BalizDeviceDataMapper balizDeviceDataMapper;

    @Value(value = "${objenious.enpoints.devices}")
    private String objeniousDevicesUrl;
    @Value(value = "${objenious.enpoints.devicesStates}")
    private String objeniousDevicesStatesUrl;
    @Value(value = "${objenious.enpoints.deviceLocation}")
    private String objeniousDeviceLocationUrl;

    @Value(value = "${baliz.endpoints.devices}")
    private String balizDevicesUrl;
    @Value(value = "${baliz.endpoints.device.data}")
    private String balizDevicesDataUrl;

    @Override
    public void doImport() {
        importObjeniousDevice();
        importObjeniousDevicesStates();
        importObjeniousDevicesLocations();

        importBalizDevice();
        importBalizDeviceData();
    }

    /**
     * Import devices from Objenious to MongoDB.
     */
    private void importObjeniousDevice() {
        ResponseEntity<List<ObjeniousDeviceDto>> deviceDtoResponse = objeniousRestTemplate.exchange(objeniousDevicesUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ObjeniousDeviceDto>>() {
        });

        deviceDtoResponse.getBody().forEach(
                objeniousDeviceDto -> objeniousDeviceRepository.save(objeniousDeviceMapper.toDevice(objeniousDeviceDto))
        );
    }

    /**
     * Import devices states. One state per device, as per the API.
     */
    private void importObjeniousDevicesStates() {
        List<ObjeniousDevice> objeniousDevices = objeniousDeviceRepository.findAll();

        String devicesListString = objeniousDevices.stream().map(objeniousDevice -> objeniousDevice.getId()).collect(Collectors.joining(","));

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(objeniousDevicesStatesUrl)
                .queryParam("id", devicesListString);

        ObjeniousDevicesStatesWrapperDto objeniousDevicesStatesWrapperDto = objeniousRestTemplate.getForObject(builder.toUriString(), ObjeniousDevicesStatesWrapperDto.class);

        objeniousDevicesStatesWrapperDto.getStates().forEach(
                deviceStateDto -> objeniousDeviceStateRepository.save(objeniousDeviceStateMapper.toDeviceState(deviceStateDto))
        );
    }

    /**
     * Import devices locations history. Objenious only keeps the last 10 locations.
     */
    private void importObjeniousDevicesLocations() {
        List<ObjeniousDevice> objeniousDevices = objeniousDeviceRepository.findAll();
        objeniousDevices.forEach(
                objeniousDevice -> {
                    ObjeniousDeviceLocationWrapperDto objeniousDeviceLocationWrapperDto = objeniousRestTemplate.getForObject(MessageFormat.format(objeniousDeviceLocationUrl, objeniousDevice.getId()), ObjeniousDeviceLocationWrapperDto.class);

                    objeniousDeviceLocationWrapperDto.getLocations().forEach(
                            deviceLocationDto -> {
                                if (objeniousDeviceLocationRepository.findByTimestampAndDeviceId(deviceLocationDto.getTimestamp(), objeniousDevice.getId()) == null) {
                                    ObjeniousDeviceLocation objeniousDeviceLocation = objeniousDeviceLocationMapper.toDeviceLocation(deviceLocationDto);
                                    objeniousDeviceLocation.setDeviceId(objeniousDevice.getId());
                                    objeniousDeviceLocationRepository.save(objeniousDeviceLocation);
                                }
                            }
                    );
                }
        );
    }


    /**
     * Import baliz devices from magrenouille (mdr) to mongo
     */
    private void importBalizDevice() {
        ResponseEntity<BalizDevicesWrapperDto> balizDeviceDtoResponse = balizRestTemplate.exchange(balizDevicesUrl, HttpMethod.GET, null, BalizDevicesWrapperDto.class);

        balizDeviceDtoResponse.getBody().getDevices().forEach(
                balizDeviceDto -> balizDeviceRepository.save(balizDeviceMapper.toBalizDevice(balizDeviceDto))
        );
    }

    /**
     * Import all baliz devices data from magrenouille to mongo
     */
    private void importBalizDeviceData() {
        balizDeviceRepository.findAll().forEach(balizDevice -> {
            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromUriString(balizDevicesDataUrl)
                    .queryParam("device", balizDevice.getId());

            BalizDeviceDataWrapperDto balizDeviceDataWrapperDto = balizRestTemplate.getForObject(builder.toUriString(), BalizDeviceDataWrapperDto.class);
            balizDeviceDataWrapperDto.getData()
                    .forEach(balizDeviceDataDto -> {
                        balizDeviceDataDto.setLatitude(RandomLocationGenerator.randomLatitude());
                        balizDeviceDataDto.setLongitude(RandomLocationGenerator.randomLongitude());
                        BalizDeviceData balizDeviceData = balizDeviceDataMapper.toBalizDeviceData(balizDeviceDataDto);
                        balizDeviceData.setDeviceId(balizDevice.getId());
                        balizDeviceDataRepository.save(balizDeviceData);
                        log.info("Data imported for baliz: " + balizDevice.getId());
                    });
        });
    }
}
