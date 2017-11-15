package lu.sgbt.tuto.ha.service;

import java.util.List;

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
public interface DeviceService {
    Device createDevice(DtoDevice device);

    Device updateDevice(Device device);

    Device getDevice(long id);

    List<Device> getAllDevices();
}
