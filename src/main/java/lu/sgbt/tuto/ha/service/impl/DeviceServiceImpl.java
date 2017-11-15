package lu.sgbt.tuto.ha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.extern.slf4j.Slf4j;
import lu.sgbt.tuto.ha.domain.factory.DeviceFactory;
import lu.sgbt.tuto.ha.domain.json.DtoDevice;
import lu.sgbt.tuto.ha.domain.model.Device;
import lu.sgbt.tuto.ha.repository.DeviceRepository;
import lu.sgbt.tuto.ha.service.DeviceService;

/**
 * Created by Hedi Ayed on 14/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceFactory deviceFactory;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        deviceFactory = new DeviceFactory();
    }

    /**
     * Create and persist new device using a dto object
     * @param device the DTO input device
     * @return a persisted entity device
     */
    @Override
    public Device createDevice(DtoDevice device) {
        log.info("Create new device {}",device);
        Device d = deviceFactory.buildDevice(device);
        return deviceRepository.save(d);
    }

    @Override
    public Device updateDevice(Device device) {
        log.info("Update device {}", device.getId());
        return deviceRepository.save(device);
    }


    /**
     * Get a device by id
     * @param id: the id of the device to return
     * @return device if any found, null otherwise
     */
    @Override
    public Device getDevice(long id) {
        log.info("Looking for device {}", id);
        return deviceRepository.findOne(id);
    }


    /**
     * Return All the devices
     * @return a List of devices
     */

    @Override
    public List<Device> getAllDevices() {
        log.info("Get all devices ");
        return StreamSupport
                .stream(deviceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


}
