package solucao1;

import gateway.OrderGateway;
import gateway.RequestInvoice;
import gateway.UserGateway;
import model.*;

import java.math.BigDecimal;
import java.util.List;

public abstract class CreateNFEAbstract {
    private OrderGateway orderGateway;
    private UserGateway userGateway;
    private RequestInvoice requestInvoice;

    public CreateNFEAbstract(OrderGateway orderGateway, UserGateway userGateway, RequestInvoice requestInvoice) {
        this.orderGateway = orderGateway;
        this.userGateway = userGateway;
        this.requestInvoice = requestInvoice;
    }

    public abstract BigDecimal calcTax(Order order);
    public abstract List<String> getMessages(Order order);
    public abstract Buyer getFinalBuyer(Buyer buyer);

    public Invoice execute(String idOrder) {
        Order order = orderGateway.getOrder(idOrder);
        Buyer buyer = (Buyer) userGateway.getUser(order.buyerId());
        Seller seller = (Seller) userGateway.getUser(order.sellerId());

        BigDecimal totalAmount;

        BigDecimal tax = calcTax(order);
        totalAmount = order.valor().add(tax);

        // Adiciona mensagens
        List<String> messages = getMessages(order);

        // Altera dados do comprador
        buyer = getFinalBuyer(buyer);

        Invoice invoice = new Invoice(idOrder, totalAmount, buyer, seller, new AdditionalMessages(messages));
        return requestInvoice.request(invoice);
    };
}
