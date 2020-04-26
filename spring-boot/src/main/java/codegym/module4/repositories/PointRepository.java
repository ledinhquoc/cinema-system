package codegym.module4.repositories;

import codegym.module4.entities.Point;
import codegym.module4.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findByIdCustomer(Customer idCustomer);

    List<Point> findByDateCreatBetweenAndIdCustomerAndAndPointStatus(Date from, Date to, Customer idCustomer,
            String status);

}
