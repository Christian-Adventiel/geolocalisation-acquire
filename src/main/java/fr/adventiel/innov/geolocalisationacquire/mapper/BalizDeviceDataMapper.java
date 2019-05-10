package fr.adventiel.innov.geolocalisationacquire.mapper;

import fr.adventiel.innov.geolocalisationacquire.domain.BalizDeviceData;
import fr.adventiel.innov.geolocalisationacquire.dto.baliz.BalizDeviceDataDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Anto on 03/05/19.
 */
@Mapper(componentModel = "spring")
public interface BalizDeviceDataMapper {

    BalizDeviceData toBalizDeviceData(BalizDeviceDataDto balizDeviceDataDto);

    BalizDeviceDataDto toBalizDeviceDataDto(BalizDeviceData balizDeviceData);

    List<BalizDeviceDataDto> toBalizDeviceDataDtos(List<BalizDeviceData> balizDeviceDataList);
}
