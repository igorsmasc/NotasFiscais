package gateway;

import model.Order;

public interface OrderGateway {
    Order getOrder(String orderId);
}
