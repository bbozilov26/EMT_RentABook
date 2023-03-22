package mk.ukim.finki.rentabook.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"stackTrace", "cause", "suppressed"})
public class BookDoesNotExistException extends LocalizedRuntimeException {

    public BookDoesNotExistException(){
        super();
    }
}
