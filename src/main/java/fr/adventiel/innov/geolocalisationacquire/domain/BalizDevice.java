package fr.adventiel.innov.geolocalisationacquire.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Baliz device bean
 * Created by Anto on 03/05/19.
 */
@Data
@Document
public class BalizDevice {

    private String id;
    private String name;
}
