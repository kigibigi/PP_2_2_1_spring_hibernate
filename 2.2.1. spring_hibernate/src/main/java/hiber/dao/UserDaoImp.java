package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(int series, String model) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().
                              createQuery("SELECT u FROM User u INNER JOIN Car c " +
                                             "ON u.userCar.id = c.id " +
                                             "WHERE c.series = :ser AND c.model = :model",
                                      User.class)
                            .setParameter("ser", series)
                            .setParameter("model", model);
      return query.getSingleResult();
   }
}
