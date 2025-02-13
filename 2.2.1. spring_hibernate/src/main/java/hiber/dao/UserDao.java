package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCar(int series, String model);
}
