package gateway;

import model.Invoice;

public interface RequestInvoice {
    Invoice request(Invoice invoice);
}
