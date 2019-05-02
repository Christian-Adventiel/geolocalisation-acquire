package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import lombok.Data;

@Data
public class DeviceDto {
    private String id;
    private String link;
    private String label;
    private String status;
    private boolean enabled;
    private boolean recycled;
}
