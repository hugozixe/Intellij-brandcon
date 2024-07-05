package EZEN.brandcon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NoSuchElementException.class)
//    ResponseEntity<Object> handleNoSuchException(NoSuchElementException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
//    }

    public record Error(String code,
                        String message
    ) {
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    Error handleNoSuchException(NoSuchElementException exception) {
        return new Error(
                "NOT_FOUND_PRODUCT",
                exception.getMessage()
        );
    }

}
