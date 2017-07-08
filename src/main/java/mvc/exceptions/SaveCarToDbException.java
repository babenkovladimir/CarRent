package mvc.exceptions;

/**
 * Created by Владимир on 05.07.2017.
 */
public class SaveCarToDbException extends RuntimeException {

    public SaveCarToDbException(String message) {
        super(message);
    }
}
