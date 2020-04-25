package codegym.module4.QuocVietPackage.Repositories;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PointRepository extends JpaRepository<point, Long> {

    List<point> findByIdCustomer(customer idCustomer);


    List<point> findByDateCreatBetweenAndIdCustomerAndAndPointStatus(Date from, Date to, customer idCustomer, String status);


}
