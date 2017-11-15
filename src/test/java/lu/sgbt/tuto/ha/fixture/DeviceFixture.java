package lu.sgbt.tuto.ha.fixture;

import lu.sgbt.tuto.ha.domain.enums.DeviceType;
import lu.sgbt.tuto.ha.domain.enums.Location;
import lu.sgbt.tuto.ha.domain.enums.Unit;
import lu.sgbt.tuto.ha.domain.factory.DeviceFactory;
import lu.sgbt.tuto.ha.domain.json.DtoDevice;
import lu.sgbt.tuto.ha.domain.model.Device;

/**
 * Created by Hedi Ayed on 15/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
public class DeviceFixture {
    private static final DeviceFactory deviceFactory = new DeviceFactory();

    public static Device createDevice() {
        Device device = new Device();
        device.setId((long)(Math.random()*100));
        device.setUnit(Math.random() > 0.5 ? Unit.DEG : Unit.PER);
        device.setType(Math.random() > 0.5 ? DeviceType.DIMMER : DeviceType.ON_OFF);
        device.setState((int)(Math.random()*100));
        device.setName("device"+device.getId());
        device.setLocation(Math.random() > 0.5 ? Location.BEDROOM : Location.KITCHEN);
        device.setHardware("hardware");
        return device;
    }

    public static DtoDevice createDtoDevice(){
        return deviceFactory.buildDevice(createDevice());
    }
}
