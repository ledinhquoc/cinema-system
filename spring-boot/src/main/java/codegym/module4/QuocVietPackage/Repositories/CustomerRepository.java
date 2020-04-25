package codegym.module4.QuocVietPackage.Repositories;

import codegym.module4.QuocVietPackage.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<customer, Integer> {


}
