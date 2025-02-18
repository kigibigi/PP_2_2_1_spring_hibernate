package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
   void addUser(User user);
   List<User> getListUsers();
   User getUserByCar(int series, String model);
}
