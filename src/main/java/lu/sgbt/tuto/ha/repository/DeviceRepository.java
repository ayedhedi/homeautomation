package lu.sgbt.tuto.ha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lu.sgbt.tuto.ha.domain.model.Device;

/**
 * Created by Hedi Ayed on 14/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
}
