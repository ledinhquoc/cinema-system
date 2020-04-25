package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.customer;

import java.util.Date;
import java.util.List;

public interface pointService {


    List<point> findPointByDate(customer idCustomer);
    List<point> findPointByDate2(Date form, Date to, customer idCustomer, String status);
    List<point> findAllPoint();

}
