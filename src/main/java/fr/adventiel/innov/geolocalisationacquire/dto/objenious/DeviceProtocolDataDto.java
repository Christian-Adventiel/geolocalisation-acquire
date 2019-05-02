package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeviceProtocolDataDto {
    @JsonProperty(value = "appnonce")
    private String appnonce;
    @JsonProperty(value = "devaddr")
    private String devaddr;
    @JsonProperty(value = "devnonce")
    private String devnonce;
    @JsonProperty(value = "netid")
    private String netid;
    @JsonProperty(value = "port")
    private int port;
    @JsonProperty(value = "snr")
    private double snr;
    @JsonProperty(value = "rssi")
    private double rssi;
    @JsonProperty(value = "gateways")
    private int gateways;
    @JsonProperty(value = "best_gateway_id")
    private String bestGatewayId;
    @JsonProperty(value = "signal")
    private double signal;
    @JsonProperty(value = "sf")
    private int sf;
    @JsonProperty(value = "noise")
    private double noise;
}
