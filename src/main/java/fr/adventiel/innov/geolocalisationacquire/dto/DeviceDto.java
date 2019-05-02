package fr.adventiel.innov.geolocalisationacquire.dto;

import lombok.Data;

@Data
public class DeviceDto {
    private long id;
    private String link;
    private String label;
    private String status;
    private boolean enabled;
    private boolean recycled;
}
