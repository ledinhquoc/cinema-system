package codegym.module4.promotions.service.Iplm;

import codegym.module4.promotions.entity.Promotions;

import java.util.List;

public interface PromotionService {
    List<Promotions> findAll();

    Promotions findById(Long id);

    void save(Promotions promotions);

    void remove(Long id);
}
