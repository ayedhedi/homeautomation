package lu.sgbt.tuto.ha.domain.json;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoDevice {
    private Long id;
    private String hardware;
    private String name;
    private String location;
    private String type;
    private String unit;
    private int state;


    @Override
    public String toString() {
        return "DtoDevice{" +
                "id=" + id +
                ", hardware='" + hardware + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", state=" + state +
                '}';
    }
}
