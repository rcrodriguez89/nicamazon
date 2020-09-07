package ni.edu.nicamazon.infrastructure.error;

import ni.edu.nicamazon.dto.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ExceptionManager4Rest {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorDetail> manageResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTime(new Date().getTime());
        errorDetail.setState(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Resource not found.");
        errorDetail.setDescription(e.getMessage());
        errorDetail.setTechMessage(e.getClass().getName());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDetail> manageMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTime(new Date().getTime());
        errorDetail.setState(HttpStatus.BAD_REQUEST.value());
        errorDetail.setTitle("Validation fails.");
        errorDetail.setDescription(e.getMessage());
        errorDetail.setTechMessage(e.getClass().getName());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetail> manageGeneralException(Exception e, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTime(new Date().getTime());
        errorDetail.setState(HttpStatus.BAD_REQUEST.value());
        errorDetail.setTitle("Something is wrong.");
        errorDetail.setDescription(e.getMessage());
        errorDetail.setTechMessage(e.getClass().getName());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.BAD_REQUEST);
    }
}
