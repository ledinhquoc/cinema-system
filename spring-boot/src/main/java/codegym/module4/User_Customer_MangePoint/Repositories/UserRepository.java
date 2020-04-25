package codegym.module4.User_Customer_MangePoint.Repositories;

import codegym.module4.User_Customer_MangePoint.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {


}
