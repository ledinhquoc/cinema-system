package codegym.module4.repositories;

import codegym.module4.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer>
{
}
