package solucao2.usecase;

import gateway.OrderGateway;
import gateway.RequestInvoice;
import gateway.UserGateway;
import model.*;
import solucao2.CalcTax;
import solucao2.GetBuyer;
import solucao2.GetMessages;

import java.math.BigDecimal;
import java.util.List;

public class CreateNFE_2 {
    private OrderGateway orderGateway;
    private UserGateway userGateway;
    private RequestInvoice requestInvoice;
    private CalcTax calcTax;
    private GetMessages getMessages;
    private GetBuyer getBuyer;

    public CreateNFE_2(OrderGateway orderGateway, UserGateway userGateway, RequestInvoice requestInvoice, CalcTax calcTax, GetMessages getMessages, GetBuyer getBuyer) {
        this.orderGateway = orderGateway;
        this.userGateway = userGateway;
        this.requestInvoice = requestInvoice;
        this.calcTax = calcTax;
        this.getMessages = getMessages;
        this.getBuyer = getBuyer;
    }

    public Invoice execute(String idOrder) {
        // buscar dados essenciais
        Order order = orderGateway.getOrder(idOrder);
        Buyer buyer = (Buyer) userGateway.getUser(order.buyerId());
        Seller seller = (Seller) userGateway.getUser(order.sellerId());

        BigDecimal totalAmount;
        // Adiciona impostos
        BigDecimal tax = calcTax.calc(order);
        totalAmount = order.valor().add(tax);

        // Adiciona mensagens
        List<String> messages = getMessages.getMessages(order);

        // Altera dados do comprador
        buyer = getBuyer.getBuyer(buyer);

        Invoice invoice = new Invoice(idOrder, totalAmount, buyer, seller, new AdditionalMessages(messages));
        return requestInvoice.request(invoice);
    }

}
