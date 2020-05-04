package codegym.module4.services;

import codegym.module4.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService
{
    List<Movie> findAll();
    Optional<Movie> findById(int id);
}
