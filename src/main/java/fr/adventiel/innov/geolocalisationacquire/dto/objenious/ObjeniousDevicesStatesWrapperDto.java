package fr.adventiel.innov.geolocalisationacquire.dto.objenious;

import lombok.Data;

import java.util.List;

@Data
public class ObjeniousDevicesStatesWrapperDto {
    List<ObjeniousDeviceStateDto> states;
}
