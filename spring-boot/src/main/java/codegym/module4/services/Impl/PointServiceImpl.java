package codegym.module4.services.Impl;

import codegym.module4.entities.Point;
import codegym.module4.entities.Customer;
import codegym.module4.repositories.PointRepository;
import codegym.module4.services.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    @Autowired
    private PointRepository pointRepository;

    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Point> findPointByDate(Customer idCustomer) {
        return pointRepository.findByIdCustomer(idCustomer);
    }

    @Override
    public List<Point> findPointByDate2(Date form, Date to, Customer idCustomer, String status) {
        return pointRepository.findByDateCreatBetweenAndIdCustomerAndAndPointStatus(form, to, idCustomer, status);
    }

    @Override
    public List<Point> findAllPoint() {
        return pointRepository.findAll();
    }
}
