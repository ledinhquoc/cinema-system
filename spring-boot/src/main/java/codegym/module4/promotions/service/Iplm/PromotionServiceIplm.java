package codegym.module4.promotions.service.Iplm;

import codegym.module4.promotions.entity.Promotions;
import codegym.module4.promotions.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceIplm implements codegym.module4.promotions.service.Iplm.PromotionService {
    @Autowired
    public PromotionRepository promotionRepository;
    @Override
    public List<Promotions> findAll() {
        return (List<Promotions>) promotionRepository.findAll();
    }

    @Override
    public Promotions findById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Promotions promotions) {
        promotionRepository.save(promotions);
    }

    @Override
    public void remove(Long id) {
        promotionRepository.deleteById(id);
    }
}
