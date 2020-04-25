package codegym.module4.User_Customer_MangePoint.Services;

import codegym.module4.User_Customer_MangePoint.Entities.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);

    List<user> findAllUsers();

    user save(user user);



}
