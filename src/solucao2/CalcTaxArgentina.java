package solucao2;

import model.Order;

import java.math.BigDecimal;

public class CalcTaxArgentina implements CalcTax {

    @Override
    public BigDecimal calc(Order order) {
        return BigDecimal.TWO;
    }
}
