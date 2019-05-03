package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ObjeniousDeviceDataDto {
    @JsonProperty(value = "application_id")
    private int applicationId;
    @JsonProperty(value = "battery_level")
    private float batteryLevel;
    @JsonProperty(value = "cap")
    private float cap;
    @JsonProperty(value = "device_id")
    private float deviceId;
    @JsonProperty(value = "g_v")
    private float gV;
    @JsonProperty(value = "latitude")
    private double latitude;
    @JsonProperty(value = "longitude")
    private double longitude;
    @JsonProperty(value = "nb_satellites")
    private int nbSatellites;
    @JsonProperty(value = "timesamp")
    private Date timestamp;
    @JsonProperty(value = "tor_status")
    private float torStatus;
    @JsonProperty(value = "vitesse")
    private float vitesse;
}
