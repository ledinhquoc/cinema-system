package codegym.module4.services.Impl;

import codegym.module4.entities.point;
import codegym.module4.entities.customer;
import codegym.module4.repositories.PointRepository;
import codegym.module4.services.pointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<point> findPointByDate(customer idCustomer) {
        return pointRepository.findByIdCustomer(idCustomer);
    }

    @Override
    public List<point> findPointByDate2(Date form, Date to, customer idCustomer, String status) {
        return pointRepository.findByDateCreatBetweenAndIdCustomerAndAndPointStatus(form, to, idCustomer, status);
    }

    @Override
    public List<point> findAllPoint() {
        return pointRepository.findAll();
    }
}
