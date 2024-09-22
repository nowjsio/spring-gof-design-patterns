package nowjsio.gof.design.patterns.facade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderFacadeService {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    public static String SUCCESS_RESPONSE = "Your order has been successfully processed";

    public String placeOrder(String productId, int quantity) {

        if (!"1".equals(productId) || quantity != 1) {
            return "Invalid input: productId must be '1' and quantity must be 1";
        }

        if (!inventoryService.isAvailable(productId, quantity)) {
            return "Product is out of stock.";
        }

        boolean paymentSuccessful = paymentService.processPayment(productId, quantity);
        if (!paymentSuccessful) {
            return "Payment failed.";
        }

        shippingService.shipProduct(productId, quantity);
        return SUCCESS_RESPONSE;
    }
}
