package lu.sgbt.tuto.ha.domain.factory;

import lu.sgbt.tuto.ha.domain.enums.DeviceType;
import lu.sgbt.tuto.ha.domain.enums.Location;
import lu.sgbt.tuto.ha.domain.enums.Unit;
import lu.sgbt.tuto.ha.domain.json.DtoDevice;
import lu.sgbt.tuto.ha.domain.model.Device;

/**
 * Created by Hedi Ayed on 14/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
public class DeviceFactory {

    public Device buildDevice(DtoDevice dto) {
        Device d = new Device();
        d.setId(dto.getId());
        d.setHardware(dto.getHardware());
        d.setLocation(buildLocation(dto.getLocation()));
        d.setName(dto.getName());
        d.setState(dto.getState());
        d.setType(buildDeviceType(dto.getType()));
        d.setUnit(buildUnit(dto.getUnit()));
        return d;
    }

    public DtoDevice buildDevice(Device device) {
        DtoDevice dto = new DtoDevice();
        dto.setId(device.getId());
        dto.setHardware(device.getHardware());
        if (device.getLocation() != null) {
            dto.setLocation(device.getLocation().getValue());
        }
        if (device.getType() != null) {
            dto.setType(device.getType().getValue());
        }
        if (device.getUnit() != null){
            dto.setUnit(device.getUnit().getValue());
        }
        dto.setName(device.getName());
        dto.setState(device.getState());
        return dto;
    }

    public Location buildLocation(String location) {
        if (Location.KITCHEN.getValue().equals(location)) {
            return Location.KITCHEN;
        }
        if (Location.LIVING_ROOM.getValue().equals(location)){
            return Location.LIVING_ROOM;
        }
        if (Location.BEDROOM.getValue().equals(location)) {
            return Location.BEDROOM;
        }
        if (Location.BEDROOM2.getValue().equals(location)){
            return Location.BEDROOM2;
        }
        if (Location.BEDROOM3.getValue().equals(location)){
            return Location.BEDROOM3;
        }

        return null;
    }

    public DeviceType buildDeviceType(String type) {
        if (DeviceType.DIMMER.getValue().equals(type)) {
            return DeviceType.DIMMER;
        }
        if (DeviceType.ON_OFF.getValue().equals(type)) {
            return DeviceType.ON_OFF;
        }
        if (DeviceType.SENSOR.getValue().equals(type)){
            return DeviceType.SENSOR;
        }
        return null;
    }

    public Unit buildUnit(String unit) {
        if (Unit.DEG.getValue().equals(unit)) {
            return Unit.DEG;
        }
        if (Unit.PER.getValue().equals(unit)){
            return Unit.PER;
        }
        return null;
    }
}
