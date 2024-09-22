package nowjsio.gof.design.patterns.facade.service;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public void shipProduct(String productId, int quantity) {
        System.out.println("Shipping product " + productId + " with quantity " + quantity);
    }
}
