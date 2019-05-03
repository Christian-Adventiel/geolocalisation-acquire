package fr.adventiel.innov.geolocalisationacquire.dto.baliz;

import lombok.Data;

import java.util.List;

/**
 * Wrapper for {@link BalizDeviceDataDto}
 * Created by Anto on 03/05/19.
 */
@Data
public class BalizDeviceDataWrapperDto {

    List<BalizDeviceDataDto> balizDeviceDataDtos;
}
