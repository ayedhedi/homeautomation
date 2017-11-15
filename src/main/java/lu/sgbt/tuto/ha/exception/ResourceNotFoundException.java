package lu.sgbt.tuto.ha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Hedi Ayed on 15/11/2017.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
