package solucao2;

import model.Order;

import java.math.BigDecimal;

public interface CalcTax {
    BigDecimal calc(Order order);
}
