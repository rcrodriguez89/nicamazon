package ni.edu.nicamazon.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ResourceNotFoundException(String arg0) {
        super(arg0);
    }
}
