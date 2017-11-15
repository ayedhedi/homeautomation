package lu.sgbt.tuto.ha.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Hedi Ayed on 14/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Getter
@AllArgsConstructor
public enum DeviceType {
    ON_OFF("onOff"),
    DIMMER("dimmer"),
    SENSOR("sensor")

    ;
    private String value;
}
