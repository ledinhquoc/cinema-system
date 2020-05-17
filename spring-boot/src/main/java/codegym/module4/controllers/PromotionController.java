package codegym.module4.controllers;


import codegym.module4.entities.Promotion;

import codegym.module4.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class PromotionController {
    @Autowired
    private PromotionService promotionService;
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path = "promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Promotion> getAllPromotions() {
        return promotionService.findAll();
    }

    @GetMapping(path = "promotions/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable int id){
        return promotionService.findById(id);
    }

    @PostMapping(path = "promotions")
    public Promotion CreatPromotion(@RequestBody Promotion promotion) {
        return promotionService.save(promotion);
    }

    @PostMapping(path = "promotions/add")
    public List<Promotion> saveAll(@RequestBody List<Promotion> promotions) {
        return promotionService.saveAll(promotions);
    }

    @PutMapping(path = "promotions/edit")
    @Transactional
    public List<Promotion> EditAllPromotion(@RequestBody List<Promotion> promotion) {
        return (List<Promotion>) promotionService.saveAll(promotion);
    }


    @DeleteMapping(path = "promotions/delete/{id}")
    @Transactional
    public void deletePromotion(@PathVariable int id) {
        Query query = entityManager.createNativeQuery("delete from promotion where promotion.id = :id", Promotion.class)
                        .setParameter("id", id);
        query.executeUpdate();
    }
}
