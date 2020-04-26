package codegym.module4.services;

import codegym.module4.entities.Point;
import codegym.module4.entities.Customer;

import java.util.Date;
import java.util.List;

public interface PointService {


    List<Point> findPointByCustomer(Customer Customer);
    List<Point> findPointByDateFormDate(Date form, Date to, Customer idCustomer, String status);
    List<Point> findAllPoint();

}
