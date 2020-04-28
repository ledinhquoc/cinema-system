package codegym.module4.services;

import codegym.module4.entities.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findUserById(Integer id);

    List<User> findAllUsers();

    User save(User user);
}
