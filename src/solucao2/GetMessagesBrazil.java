package solucao2;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class GetMessagesBrazil implements GetMessages {
    @Override
    public List<String> getMessages(Order order) {
        List<String> messages = new ArrayList<>();
        messages.add("Valor de pais 1923");

        if(order.type() == "CELLPHONE") {
            messages.add("IMEI VALUE - 12312312312323");
        }

        return messages;
    }
}
