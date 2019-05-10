package fr.adventiel.innov.geolocalisationacquire.dto.baliz;

import lombok.Data;

import java.util.Date;

/**
 * Baliz device data dto
 * Created by Anto on 03/05/19.
 */
@Data
public class BalizDeviceDataDto {
    private String deviceId;
    private Date timestamp;
    private Long temperature;
    private Long pressure;
    private Long humidity;
    private Long luminosity;
    private Double battery;
    private Double latitude;
    private Double longitude;
}
