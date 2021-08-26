package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoHibernateImpl  implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void saveUser(String name, String lastName, int age) {
        User user = new User(name, lastName, age);
        entityManager.persist(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public User findOne(final long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(long id) {

        delete(findOne(id));

    }

    @Override
    public List<User> getAllUsers() {
                  return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    @Override
    public User getUser(long id) {
        return   findOne(id);
    }

    public  void updateUser(User user){
       entityManager.merge(user);
    }
}
