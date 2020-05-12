package codegym.module4.controllers;

import codegym.module4.entities.Customer;
import codegym.module4.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ListCustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }


    @RequestMapping(value = "customers",
            method = RequestMethod.POST)
    public ResponseEntity<Customer> createProduct(
            @RequestBody Customer customer,
            UriComponentsBuilder builder) {
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
//    @PostMapping (value = "/customers")
//    public

}
