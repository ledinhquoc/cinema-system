package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.user;

import java.util.List;

public interface userService {

    user findUserById(Long id);

    List<user> findAllUsers();

    user save(user User);
}
