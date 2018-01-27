package ro.ubb.istudent.exception;

/**
 * Created by Deni on 26/01/2018.
 */
public class EntityNotValidException extends RuntimeException {

    public EntityNotValidException(String message) {
        super(message);
    }
}
