package codegym.module4.services.Impl;

import codegym.module4.entities.Point;
import codegym.module4.repositories.PointRepo;
import codegym.module4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PointServiceImpl implements PointService
{
    @Autowired
    private PointRepo pointRepo;
    @Override
    public List<Point> findAll()
    {
        return pointRepo.findAll();
    }
}
