package lu.sgbt.tuto.ha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import lu.sgbt.tuto.ha.domain.factory.DeviceFactory;
import lu.sgbt.tuto.ha.domain.json.DtoDevice;
import lu.sgbt.tuto.ha.domain.model.Device;
import lu.sgbt.tuto.ha.exception.ResourceNotFoundException;
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
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final DeviceFactory deviceFactory;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
        deviceFactory = new DeviceFactory();
    }

    @GetMapping
    public List<DtoDevice> getAllDevices(){
        log.info("Looking for all devices ");
        List<DtoDevice> devices = deviceService.getAllDevices().stream()
                                                .map(deviceFactory::buildDevice)
                                                .collect(Collectors.toList());
        log.info("Returns {} devices", devices.size());
        return devices;
    }


    @GetMapping("/{id}")
    public DtoDevice getDeviceById(@PathVariable("id") long id) throws ResourceNotFoundException {

        log.info("Looking for device {}",id);
        Device device = deviceService.getDevice(id);

        if (device != null) {
            DtoDevice d = deviceFactory.buildDevice(device);
            log.info("One device found: {}", d);

            return d;
        }else {
            throw new ResourceNotFoundException("Cannot found device with id = "+id);
        }
    }

    @PutMapping
    public DtoDevice createOrUpdateDevice(
            @RequestBody DtoDevice device,
            HttpServletResponse response) throws ResourceNotFoundException {

        Device d;

        if (device.getId() != null) {
            d = deviceService.getDevice(device.getId());
            if (d != null) {
                log.info("Update device {}",device.getId());
                d = deviceFactory.buildDevice(device);
                d = deviceService.updateDevice(d);
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
            }else {
                log.warn("Cannot update device, unknown id = {}", device.getId());
                throw new ResourceNotFoundException("Cannot found device with id = "+device.getId());
            }
        }else {
            log.info("Create new device");
            d = deviceService.createDevice(device);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }

        return deviceFactory.buildDevice(d);
    }
}
