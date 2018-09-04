package thai.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    @ExceptionHandler
    public ResponseEntity globalHandler(Exception exception) {
        log.error("Exception thrown:", exception);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(exception);
    }
}
