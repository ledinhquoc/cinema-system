package codegym.module4.Repositories;

import codegym.module4.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {


}
