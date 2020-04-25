package codegym.module4.User_Customer_MangePoint.Repositories;

import codegym.module4.User_Customer_MangePoint.Entities.point;
import codegym.module4.User_Customer_MangePoint.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PointRepository extends JpaRepository<point, Long> {

    List<point> findByIdCustomer(customer idCustomer);


    List<point> findByDateCreatBetweenAndIdCustomerAndAndPointStatus(Date from, Date to, customer idCustomer, String status);


}
