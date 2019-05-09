package fr.adventiel.innov.geolocalisationacquire.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Baliz device data bean
 * Created by Anto on 03/05/19.
 */
@Data
@Document
public class BalizDeviceData {

    private Long timestamp;
    private Long temperature;
    private Long pressure;
    private Long humidity;
    private Long luminosity;
    private Double battery;
    private Double latitude;
    private Double longitude;
}
