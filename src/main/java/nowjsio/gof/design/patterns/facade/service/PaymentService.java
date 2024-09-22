package nowjsio.gof.design.patterns.facade.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public boolean processPayment(String productId, int quantity) {
        // Add processing payment logic
        return true;
    }
}
