package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ObjeniousDeviceLocationDto {
    @JsonProperty(value = "timestamp")
    private Date timestamp;
    @JsonProperty(value = "latitude")
    private double latitude;
    @JsonProperty(value = "longitude")
    private double longitude;
    @JsonProperty(value = "geolocation_type")
    private String geolocationType;
    @JsonProperty(value = "geolocation_precision")
    private int geolocationPrecision;
    @JsonProperty(value = "city_name")
    private String cityName;
    @JsonProperty(value = "city_code")
    private int cityCode;
}
