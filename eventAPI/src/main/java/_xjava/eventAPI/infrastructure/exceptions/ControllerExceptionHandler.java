package _xjava.eventAPI.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateIdentifierException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateIdentifierException(DuplicateIdentifierException ex){
        Map<String, String> body = new HashMap<>();
        body.put("Error: ", ex.getMessage());
        body.put("Message: ", "Please, insert a valid hashId for your event and try again");
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IdentifierNotExistException.class)
    public ResponseEntity<Map<String, String>> handleIdentifierNotExistException(IdentifierNotExistException ex){
        Map<String, String> body = new HashMap<>();
        body.put("Error: ", ex.getMessage());
        body.put("Message: ", "The request event was not found, check the identifier and try again");
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
