package lu.sgbt.tuto.ha.config;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import lu.sgbt.tuto.ha.domain.json.DtoDevice;
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
@Component
public class DataInitializerService implements InitializingBean{

    private final DeviceService deviceService;

    @Autowired
    public DataInitializerService(final DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("data.json");

        if (url != null) {
            File file = new File(url.getFile());
            if (file.exists()) {
                log.info("Start parsing devices from file");
                ObjectMapper mapper = new ObjectMapper();
                List<DtoDevice> devices = mapper.readValue(file, new TypeReference<List<DtoDevice>>(){});
                log.info("{} devices found. Start saving to database.");
                devices.forEach(deviceService::createDevice);
            }
        }
    }
}
