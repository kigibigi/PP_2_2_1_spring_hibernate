package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("formula1", 1234)));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", new Car("formula2", 1235)));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("formula3", 1236)));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("formula4", 1237)));

      List<User> users = userService.getListUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+ user.getUserCar());
         System.out.println();
      }
      userService.getListUsers().stream()
                      .forEach(user -> System.out.println(user.getUserCar()));

      User user = userService.getUserByCar(1234, "formula1");
      System.out.println(user);
      context.close();
   }
}
