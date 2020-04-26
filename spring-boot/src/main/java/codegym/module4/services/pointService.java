package codegym.module4.services;

import codegym.module4.entities.Point;
import codegym.module4.entities.Customer;

import java.util.Date;
import java.util.List;

public interface PointService {

    List<Point> findPointByDate(Customer idCustomer);

    List<Point> findPointByDate2(Date form, Date to, Customer idCustomer, String status);

    List<Point> findAllPoint();

}
