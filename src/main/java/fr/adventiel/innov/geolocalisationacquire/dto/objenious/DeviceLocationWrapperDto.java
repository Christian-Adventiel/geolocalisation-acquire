package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeviceLocationWrapperDto {
    @JsonProperty(value = "locations")
    List<DeviceLocationDto> locations;
    @JsonProperty(value = "start_exclusive")
    String startExclusive;
}
