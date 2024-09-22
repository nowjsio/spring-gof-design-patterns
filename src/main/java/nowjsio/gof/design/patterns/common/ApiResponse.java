package nowjsio.gof.design.patterns.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private Object data;

    public static ResponseEntity<ApiResponse> OK(Object object) {
        return ResponseEntity.ok().body(new ApiResponse(true, object));
    }

    public static ResponseEntity<ApiResponse> BAD(Object object) {
        return ResponseEntity.badRequest().body(new ApiResponse(false, object));
    }
}