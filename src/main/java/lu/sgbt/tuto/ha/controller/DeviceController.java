package lu.sgbt.tuto.ha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import lu.sgbt.tuto.ha.domain.factory.DeviceFactory;
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

    //add API methods here

}
