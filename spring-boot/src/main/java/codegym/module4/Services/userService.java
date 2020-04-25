package codegym.module4.Services;

import codegym.module4.Entities.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);

    List<user> findAllUsers();

    user save(user user);



}
