package ro.ubb.istudent.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void processEntityNotFoundException(EntityNotFoundException ex) {
        LOG.error("Entity not found {}", ex);
    }

    @ExceptionHandler(EntityNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void processEntityNotValidException(EntityNotValidException ex) {
        LOG.error("Entity is not valid {}", ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void processAllOtherExceptions(Exception ex) {
        LOG.error("Unexpected exception. Please add a custom exception handler for ex: {}", ex);
    }
}