package fr.adventiel.innov.geolocalisationacquire.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Baliz device data bean
 * Created by Anto on 03/05/19.
 */
@Data
@Document
public class BalizDeviceData {
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
