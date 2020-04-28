package codegym.module4.repositories;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PointRepo extends JpaRepository<Point,Long>
{
    List<Point> findByCustomer(Customer idCustomer);
    List<Point> findByDateCreateBetweenAndCustomerAndPointStatus(Date from, Date to, Customer idCustomer, String status);

}
