package nowjsio.gof.design.patterns.controller;


import lombok.RequiredArgsConstructor;
import nowjsio.gof.design.patterns.common.ApiResponse;
import nowjsio.gof.design.patterns.facade.service.OrderFacadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static nowjsio.gof.design.patterns.common.ApiResponse.BAD;
import static nowjsio.gof.design.patterns.common.ApiResponse.OK;

@RestController
@RequestMapping("/patterns/structural")
@RequiredArgsConstructor
public class StructuralController extends BaseController {
    private final OrderFacadeService orderFacadeService;

    @Override
    protected List<String> getAvailableURLs() {
        return List.of(
                "/patterns/structural/facade"
        );
    }

    @RequestMapping("/facade")
    public ResponseEntity<ApiResponse> facade(
            @RequestParam(required = false) String productId,
            @RequestParam(required = false) Integer quantity) {

        if (productId == null || quantity == null) {
            return BAD("Missing required parameters: productId and quantity");
        }

        String result = this.orderFacadeService.placeOrder(productId, quantity);
        if (OrderFacadeService.SUCCESS_RESPONSE.equals(result)) {
            return OK(result);
        } else {
            return BAD(result);
        }
    }


}
