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
public enum Unit {
    DEG("°C"),
    PER("%")


    ;
    private String value;
}
