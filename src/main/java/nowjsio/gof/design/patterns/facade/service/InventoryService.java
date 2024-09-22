package nowjsio.gof.design.patterns.facade.service;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    public boolean isAvailable(String productId, int quantity) {
        // Add checking inventory logic
        return true;
    }
}
