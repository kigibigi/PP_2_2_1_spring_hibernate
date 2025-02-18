package hiber.service;

import hiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    void addUser(User user);
    List<User> getListUsers();

    User getUserByCar(int series, String model);
}
