package codegym.module4.promotions.controller;

import codegym.module4.promotions.entity.Promotions;
import codegym.module4.promotions.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(value = "/Promotions", method = RequestMethod.GET)
    public ResponseEntity<List<Promotions>> listAll() {
        List<Promotions> promotions = promotionService.findAll();
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    @RequestMapping(value = "/Promotions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promotions> getPromotion(@PathVariable("id") Long id) {
        System.out.println("Fetching Customer with id " + id);
        Promotions promotions = promotionService.findById(id);

        if (promotions == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Promotions>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Promotions>(promotions, HttpStatus.OK);
    }

}


