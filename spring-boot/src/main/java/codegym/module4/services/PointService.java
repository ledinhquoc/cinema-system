package codegym.module4.Services;

import codegym.module4.Entities.point;
import codegym.module4.Entities.customer;

import java.util.Date;
import java.util.List;

public interface pointService {


    List<point> findPointByDate(customer idCustomer);
    List<point> findPointByDate2(Date form, Date to, customer idCustomer, String status);
    List<point> findAllPoint();

}
