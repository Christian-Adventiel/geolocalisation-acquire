package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ObjeniousDeviceStateDto {
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "uplink_count")
    private int uplinkCount;
    @JsonProperty(value = "last_uplink")
    private Date lastUplink;
    @JsonProperty(value = "downlink_count")
    private int downlinkCount;
    @JsonProperty(value = "last_downlink")
    private Date lastDownlink;
    @JsonProperty(value = "data")
    ObjeniousDeviceDataDto deviceData;
    @JsonProperty(value = "lat")
    private double lat;
    @JsonProperty(value = "lng")
    private double lng;
    @JsonProperty(value = "geolocation_type")
    private String geolocationType;
    @JsonProperty(value = "protocol_data")
    ObjeniousDeviceProtocolDataDto objeniousDeviceProtocolDataDto;
}
