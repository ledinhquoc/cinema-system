package codegym.module4.services;

import codegym.module4.entities.Movie;
import codegym.module4.entities.MovieSchedules;

import java.util.List;

public interface MovieService
{
    List<Movie> findAll();
    Movie findByMovieSchedules(MovieSchedules movieSchedules);
}
