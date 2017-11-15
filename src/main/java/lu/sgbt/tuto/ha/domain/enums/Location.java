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
public enum Location {

    KITCHEN("kitchen"),
    BEDROOM("bedroom"),
    LIVING_ROOM("living room"),
    BEDROOM2("bedroom 2"),
    BEDROOM3("bedroom 3")

    ;
    private String value;
}
