package solucao2;

import model.Order;

import java.math.BigDecimal;

public class CalcTaxBrazil implements CalcTax {
    @Override
    public BigDecimal calc(Order order) {
        // QUALQUER LOGICA MALUCA FISCAL

        return BigDecimal.TEN;
    }
}
