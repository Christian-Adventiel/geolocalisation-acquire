package fr.adventiel.innov.geolocalisationacquire.dto.baliz;

import lombok.Data;

/**
 * Baliz device data dto
 * Created by Anto on 03/05/19.
 */
@Data
public class BalizDeviceDataDto {

    private Long timestamp;
    private Long temperature;
    private Long pressure;
    private Long humidity;
    private Long luminosity;
    private Double battery;
    private Double latitude;
    private Double longitude;
}
