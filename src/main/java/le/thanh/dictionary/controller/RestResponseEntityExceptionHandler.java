package le.thanh.dictionary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleInternal(Exception ex) {
        return ResponseEntity.internalServerError().body(Collections.singletonMap("message", ex.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, })
    protected Object handle(Exception ex) {
        return ResponseEntity.badRequest().body(Collections.singletonMap("message", ex.getMessage()));
    }
}