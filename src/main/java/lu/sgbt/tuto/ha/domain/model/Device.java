package lu.sgbt.tuto.ha.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lu.sgbt.tuto.ha.domain.enums.DeviceType;
import lu.sgbt.tuto.ha.domain.enums.Location;
import lu.sgbt.tuto.ha.domain.enums.Unit;

/**
 * Created by Hedi Ayed on 14/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Getter
@Setter
@Entity
public class Device implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hardware;
    private String name;
    private Location location;
    private DeviceType type;
    private Unit unit;
    private int state;
}
