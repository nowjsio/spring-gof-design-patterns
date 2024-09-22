package nowjsio.gof.design.patterns.controller;

import lombok.RequiredArgsConstructor;
import nowjsio.gof.design.patterns.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/patterns")

public class GofRestController extends BaseController {

    protected List<String> getAvailableURLs() {
        return List.of(
                "/creational",
                "/structural",
                "/behavioral"
        );
    }
}
