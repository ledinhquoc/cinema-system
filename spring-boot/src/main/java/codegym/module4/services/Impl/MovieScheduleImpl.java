package codegym.module4.services.Impl;

import codegym.module4.entities.MovieSchedule;
import codegym.module4.repositories.MovieScheduleRepo;
import codegym.module4.services.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieScheduleImpl implements MovieScheduleService
{
    @Autowired
    private MovieScheduleRepo movieScheduleRepo;


    @Override
    public List<MovieSchedule> findAll()
    {
        return movieScheduleRepo.findAll();
    }
}
