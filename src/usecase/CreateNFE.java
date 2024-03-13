package usecase;

import gateway.OrderGateway;
import gateway.RequestInvoice;
import gateway.UserGateway;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateNFE {

    // Gateway - Busca algo fora do nosso escopo ou sistema
    private OrderGateway orderGateway;
    private UserGateway userGateway;
    private RequestInvoice requestInvoice;

    // BRA - MEX - ARG
    public Invoice execute(String idOrder, String country) {
        // buscar dados essenciais
        Order order = orderGateway.getOrder(idOrder);
        Buyer buyer = (Buyer) userGateway.getUser(order.buyerId());
        Seller seller = (Seller) userGateway.getUser(order.sellerId());

        BigDecimal totalAmount;
        List<String> messages = new ArrayList<>();

        // Adiciona impostos
        if(country == "BRA") {
            totalAmount = order.valor().add(BigDecimal.TEN);
        } else if(country == "ARG") {
            totalAmount = order.valor().add(BigDecimal.TWO);
        } else {
            totalAmount = order.valor();
        }

        // Adiciona mensagens
        if(country == "BRA") {
            messages.add("Valor de pais 1923");
        }

        // Adicina mensagens de produtos
        if((country == "BRA" || country == "ARG") && order.type() == "CELLPHONE") {
            messages.add("IMEI VALUE - 12312312312323");
        }

        // Altera dados do comprador
        if(country == "MEX") {
            buyer.setName(buyer.getName() + "MX");
        } else if(country == "ARG") {
            buyer.setName(buyer.getName() + "AG");
        } else if(country == "BRA") {
            buyer.setName(buyer.getName() + "BR");
        }

        Invoice invoice = new Invoice(idOrder, totalAmount, buyer, seller, new AdditionalMessages(messages));
        return requestInvoice.request(invoice);
    }
}
