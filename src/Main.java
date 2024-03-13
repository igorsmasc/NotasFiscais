import gateway.*;
import solucao1.CreateNFEAbstract;
import solucao1.CreateNFEBrazil;
import solucao2.*;
import solucao2.usecase.CreateNFE_2;

public class Main {

    public static void main(String[] args) {
        OrderGateway orderGateway = new OrderGatewayImpl();
        UserGateway userGateway = new UserGatewayImpl();
        RequestInvoice requestInvoice = new RequestInvoiceImpl();

        CalcTaxBrazil calcTax = new CalcTaxBrazil(); // 1m
        GetMessages getMessages = new GetMessagesBrazil();
        GetBuyer getBuyer = new GetBuyerBrazil();

        CreateNFE_2 createNFE_2 = new CreateNFE_2(
                orderGateway,
                userGateway,
                requestInvoice,
                calcTax,
                getMessages,
                getBuyer
        );

        createNFE_2.execute("123");

        CreateNFEAbstract createNFEAbstract = new CreateNFEBrazil(orderGateway, userGateway, requestInvoice);
        createNFEAbstract.execute("123");

    }

}
