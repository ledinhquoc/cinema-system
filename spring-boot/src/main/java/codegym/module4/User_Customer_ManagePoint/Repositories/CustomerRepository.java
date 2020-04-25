package codegym.module4.User_Customer_MangePoint.Repositories;

import codegym.module4.User_Customer_MangePoint.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {


}
