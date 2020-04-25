package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.customer;
import codegym.module4.QuocVietPackage.Entities.user;

import java.util.List;

public interface userService {

    user findUserById(Integer id);

    List<user> findAllUsers();

    user save(user user);



}
