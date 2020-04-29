package codegym.module4.repositories;

import codegym.module4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
//    Vu add : start
    Optional<User> findByName(String username);

    Boolean existsByName(String username);


    //End

}
