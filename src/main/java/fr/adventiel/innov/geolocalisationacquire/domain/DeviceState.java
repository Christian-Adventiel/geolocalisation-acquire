package fr.adventiel.innov.geolocalisationacquire.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class DeviceState {
    @Id
    private long id;
    private String status;
    private int uplinkCount;
    private Date lastUplink;
    private int downlinkCount;
    private Date lastDownlink;
    private double lat;
    private double lng;
    private String geolocationType;
    private DeviceData deviceData;
}
