package mk.ukim.finki.rentabook.exceptions;

import mk.ukim.finki.rentabook.localization.MessageResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

//    private final MessageResolver messageResolver;
//
//    public ErrorHandler(MessageResolver messageResolver) {
//        this.messageResolver = messageResolver;
//    }

    @ExceptionHandler(AuthorDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AuthorDoesNotExistException handleAuthorDoesNotExistException(AuthorDoesNotExistException exception){
        return exception;
    }

    @ExceptionHandler(BookDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BookDoesNotExistException handleBookDoesNotExistException(BookDoesNotExistException exception){
        return exception;
    }

    @ExceptionHandler(CountryDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CountryDoesNotExistException handleCountryDoesNotExistException(CountryDoesNotExistException exception){
        return exception;
    }

}
