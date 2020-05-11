package codegym.module4.services;

import codegym.module4.entities.Promotion;
import codegym.module4.entities.Seat;

import java.util.List;

public interface PromotionService
{
    List<Promotion> findAll();
    Promotion save(Promotion promotion);

}
