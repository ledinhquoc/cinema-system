package codegym.module4.User_Customer_MangePoint.Services;

import codegym.module4.User_Customer_MangePoint.Entities.point;
import codegym.module4.User_Customer_MangePoint.Entities.customer;

import java.util.Date;
import java.util.List;

public interface pointService {


    List<point> findPointByDate(customer idCustomer);
    List<point> findPointByDate2(Date form, Date to, customer idCustomer, String status);
    List<point> findAllPoint();

}
