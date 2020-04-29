package codegym.module4.services.Impl;

import codegym.module4.entities.Promotion;
import codegym.module4.repositories.PromotionRepo;
import codegym.module4.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
