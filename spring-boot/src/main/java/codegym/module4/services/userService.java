package codegym.module4.services;

import codegym.module4.entities.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);

    List<user> findAllUsers();

    user save(user user);



}
