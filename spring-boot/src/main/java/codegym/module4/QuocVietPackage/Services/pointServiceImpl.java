package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Repositories.PointRepository;
import codegym.module4.QuocVietPackage.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Date;
import java.util.List;


@Service
public class pointServiceImpl implements pointService {
  @Autowired
    private PointRepository pointRepository;

    public pointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public List<point> findPointByDate(user idUser) {
        return pointRepository.findByIdUser(idUser);
    }

    @Override
    public List<point> findPointByDate2(Date form, Date to,user idUser,String status) {
        return pointRepository.findByDateCreatBetweenAndIdUserAndAndPointStatus(form, to, idUser, status);
    }

    @Override
    public List<point> findAllPoint() {
        return pointRepository.findAll();
    }
}
