package nowjsio.gof.design.patterns.controller;

import nowjsio.gof.design.patterns.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public abstract class BaseController {

    protected abstract List<String> getAvailableURLs();

    @RequestMapping("/**")
    public ResponseEntity<ApiResponse> handleInvalidPath() {
        return ApiResponse.BAD(Map.of("availableURLs", getAvailableURLs()));
    }
}
