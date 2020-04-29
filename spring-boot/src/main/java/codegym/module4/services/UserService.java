package codegym.module4.services;

import codegym.module4.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{

    //Vu add : Start
    Optional<User> findById(Long id);

    void delete(int id);

    void save(User user);

    List<User> findAllUser();

    Optional<User> findByName(String name);

    Boolean existsByName(String username);


    // End


}
