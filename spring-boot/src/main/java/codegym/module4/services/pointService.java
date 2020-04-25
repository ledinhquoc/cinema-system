package codegym.module4.services;

import codegym.module4.entities.point;
import codegym.module4.entities.customer;

import java.util.Date;
import java.util.List;

public interface pointService {


    List<point> findPointByDate(customer idCustomer);
    List<point> findPointByDate2(Date form, Date to, customer idCustomer, String status);
    List<point> findAllPoint();

}
