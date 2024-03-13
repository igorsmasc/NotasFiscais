package solucao1;

import gateway.OrderGateway;
import gateway.RequestInvoice;
import gateway.UserGateway;
import model.Buyer;
import model.Invoice;
import model.Order;

import java.math.BigDecimal;
import java.util.List;

public class CreateNFEArgentina extends CreateNFEAbstract {
    public CreateNFEArgentina(OrderGateway orderGateway, UserGateway userGateway, RequestInvoice requestInvoice) {
        super(orderGateway, userGateway, requestInvoice);
    }

    @Override
    public BigDecimal calcTax(Order order) {
        return null;
    }

    @Override
    public List<String> getMessages(Order order) {
        return null;
    }

    @Override
    public Buyer getFinalBuyer(Buyer buyer) {
        return null;
    }

    @Override
    public Invoice execute(String orderId) {
        return null;
    }
}
