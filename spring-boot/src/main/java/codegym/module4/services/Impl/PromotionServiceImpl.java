package codegym.module4.services.Impl;

import codegym.module4.entities.Promotion;
import codegym.module4.repositories.PromotionRepo;
import codegym.module4.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService
{
        @Autowired
        private PromotionRepo promotionRepo;
        @Override
        public List<Promotion> findAll()
        {
            return promotionRepo.findAll();
        }

        @Override
        public Promotion save(Promotion promotion) {
            return promotionRepo.save(promotion);
        }

        @Override
        public void remove(int id) {
            promotionRepo.deleteById(id);
        }

        @Override
        public Optional<Promotion> findById(int id) {
            return promotionRepo.findById(id);
        }

        @Override
        public List<Promotion> saveAll(List<Promotion> promotions) {
            return promotionRepo.saveAll(promotions);
        }
}
