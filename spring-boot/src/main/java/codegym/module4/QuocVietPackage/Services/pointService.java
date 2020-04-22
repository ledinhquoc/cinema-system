package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.user;

import java.util.Date;
import java.util.List;

public interface pointService {


    List<point> findPointByDate(user idUser);
    List<point> findPointByDate2(Date form, Date to,user idUser);
    List<point> findAllPoint();

}
