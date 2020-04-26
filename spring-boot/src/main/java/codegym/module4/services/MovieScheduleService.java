package codegym.module4.services;

import codegym.module4.entities.MovieSchedule;

import java.util.List;

public interface MovieScheduleService
{
    List<MovieSchedule> findAll();
}
