package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;

@Component
public class UserDaoHibernateImpl extends AbstractDaoClass<User> implements UserDao {

    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;

    public UserDaoHibernateImpl() {
        setClazz(User.class);
    }

    @Override
    public void saveUser(String name, String lastName, int age) {
        User user = new User(name, lastName, age);
        create(user);
    }

    @Override
    public void removeUserById(long id) {
        deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return findAll();
    }

    @Override
    public User getUser(long id) {
        return   findOne(id);
    }

    public  void updateUser(User user){
        update(user);
    }
}
