package fr.adventiel.innov.geolocalisationacquire.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Device {
    private String id;
    private String link;
    private String label;
    private String status;
    private boolean enabled;
    private boolean recycled;
}
