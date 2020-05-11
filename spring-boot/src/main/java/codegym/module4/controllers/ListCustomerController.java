package codegym.module4.controllers;

import codegym.module4.entities.Customer;
import codegym.module4.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ListCustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers()
    {
        return customerService.findAll();
    }

//    @PutMapping(path = "customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Customer> editCustomer(@PathVariable int id) {
//        customerService.findById(id)
//    }
}
