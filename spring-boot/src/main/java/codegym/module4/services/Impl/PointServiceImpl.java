package codegym.module4.services.Impl;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Point;
import codegym.module4.repositories.PointRepo;
import codegym.module4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PointServiceImpl implements PointService
{

    @Autowired
    private PointRepo pointRepo;

    public PointServiceImpl(PointRepo pointRepo) {
        this.pointRepo = pointRepo;}

    @Override
    public List<Point> findAll()
    {
        return pointRepo.findAll();
    }

    @Override
    public List<Point> findPointByCustomer(Customer customer) {
        return pointRepo.findByCustomer(customer);
    }

    @Override
public List<Point> findPointByDateFormDate(Date form, Date to, Customer idCustomer, String status) {
    return pointRepo.findByDateCreateBetweenAndCustomerAndPointStatus(form, to, idCustomer, status);
}

    @Override
    public List<Point> findAllPoint() {
        return pointRepo.findAll();
    }


}
