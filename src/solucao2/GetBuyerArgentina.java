package solucao2;

import model.Buyer;

public class GetBuyerArgentina implements GetBuyer {
    @Override
    public Buyer getBuyer(Buyer buyer) {
        buyer.setName(buyer.getName() + "AR");
        return buyer;
    }
}
