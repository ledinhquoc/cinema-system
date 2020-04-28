package codegym.module4.promotions.repository;

import codegym.module4.promotions.entity.Promotions;
import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository extends CrudRepository<Promotions ,Long> {
}
