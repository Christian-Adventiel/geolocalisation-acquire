package fr.adventiel.innov.geolocalisationacquire.dto.baliz;

import lombok.Data;

import java.util.List;

/**
 * The json array is not an array.
 * We have to use this wrapper to get the devices from Exotic.
 */
@Data
public class BalizDevicesWrapperDto {
    private List<BalizDeviceDto> devices;
}
