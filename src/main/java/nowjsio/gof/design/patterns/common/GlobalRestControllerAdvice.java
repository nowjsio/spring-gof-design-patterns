package nowjsio.gof.design.patterns.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleNoHandlerFound(NoHandlerFoundException ex) {
        return ApiResponse.BAD(Map.of("availableURLs", List.of(
                "/patterns"
        )));
    }
}
