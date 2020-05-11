package codegym.module4.services;

import codegym.module4.entities.Movie;
import codegym.module4.entities.Promotion;
import codegym.module4.entities.Seat;

import java.util.List;
import java.util.Optional;

public interface PromotionService
{
    List<Promotion> findAll();
<<<<<<< HEAD
    Promotion save(Promotion promotion);
=======

    Optional<Promotion> findById(int id);
    void save(Promotion promotion);
    void remove(Promotion promotion);
>>>>>>> 8b122d312ab15deb493403fc776a7a376b4f6c4c

}
