package codegym.module4.services;

import codegym.module4.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    List<User> findAll();

    User findUserById(Integer id);

    List<User> findAllUsers();

    User save(User user);


}
