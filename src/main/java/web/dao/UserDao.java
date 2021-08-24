package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void saveUser(String name, String lastName, int age);
    void removeUserById(long id);
    List<User> getAllUsers();
    User getUser(long id);
    void updateUser( User user);
}
