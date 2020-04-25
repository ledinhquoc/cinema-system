package codegym.module4.repositories;

import codegym.module4.entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {


}
