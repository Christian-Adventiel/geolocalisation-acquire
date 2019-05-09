package fr.adventiel.innov.geolocalisationacquire.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ObjeniousDeviceData {
    private int applicationId;
    private float batteryLevel;
    private float cap;
    private float deviceId;
    private float gV;
    private double latitude;
    private double longitude;
    private int nbSatellites;
    private Date timestamp;
    private float torStatus;
    private float vitesse;
}
