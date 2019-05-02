package fr.adventiel.innov.geolocalisationacquire.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceLocation {
    private Date timestamp;
    private double latitude;
    private double longitude;
    private String geolocationType;
    private int geolocationPrecision;
    private String cityName;
    private int cityCode;
    private long deviceId;
}
