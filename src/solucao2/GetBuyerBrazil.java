package solucao2;

import model.Buyer;

public class GetBuyerBrazil implements GetBuyer {
    @Override
    public Buyer getBuyer(Buyer buyer) {
        buyer.setName(buyer.getName() + "BR");
        return buyer;
    }
}
