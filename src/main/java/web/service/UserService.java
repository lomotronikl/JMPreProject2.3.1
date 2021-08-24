package web.service;

import web.model.User;


import java.util.List;

public interface UserService {
    void saveUser(String name, String lastName, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUser(long id);

    void updateUser(User updateUser);

}
