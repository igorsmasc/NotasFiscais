package gateway;

import model.User;

public interface UserGateway {
    User getUser(String userId);
}
