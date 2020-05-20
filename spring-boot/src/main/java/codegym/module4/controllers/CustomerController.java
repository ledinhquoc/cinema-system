package codegym.module4.controllers;


import codegym.module4.entities.Customer;
import codegym.module4.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    @Autowired
    private EntityManager entityManager;

    public static final String BASE_URL = "/api/v1/customers";


    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> getAllUser() {
        return customerService.findAllCustomer();
    }


    @GetMapping("/{id}")
    public Customer getUserByID(@PathVariable int id){
        return customerService.findByIdL(id);
    }


    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customerUpdate){
        Customer customerDetails = customerService.findCustomerById(id);
        customerDetails.setAddress(customerUpdate.getAddress());
        customerDetails.setBirthday(customerUpdate.getBirthday());
        customerDetails.setEmail(customerUpdate.getEmail());
        customerDetails.setFullName(customerUpdate.getFullName());
        customerDetails.setGender(customerUpdate.getGender());
        customerDetails.setIdCard(customerUpdate.getIdCard());
        customerDetails.setPhone(customerUpdate.getPhone());
        customerDetails.setIdCard(customerUpdate.getIdCard());
      return customerService.saveCustomer(customerDetails);
    }

    @PostMapping(path = "/new")
    public Customer newCustomer(@RequestBody Customer customer)
    {
        try {
            System.out.println(customer.getBirthday());
//            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//            String formattedDate = myDateObj.format(myFormatObj);
//            System.out.println("After formatting: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return customerService.saveCustomer(customer);
    }

    @DeleteMapping(path = "/delete/{id}")

    @Transactional
    public void deleteCustomer(@PathVariable Integer id){
//        customerService.deleteById(id);
        Query query=
                entityManager
                .createNativeQuery("delete from customer where customer.id=?1")
                        .setParameter(1,id);
        query.executeUpdate();
    }

    @PutMapping(path = "/put/{id}")
    public Customer putCustomerById(@PathVariable int id,@RequestBody Customer customerUpdate) {
        Customer customerDetails = customerService.findByIdC(id);
        customerDetails.setAddress(customerUpdate.getAddress());
        customerDetails.setBirthday(customerUpdate.getBirthday());
        customerDetails.setEmail(customerUpdate.getEmail());
        customerDetails.setFullName(customerUpdate.getFullName());
        customerDetails.setGender(customerUpdate.getGender());
        customerDetails.setIdCard(customerUpdate.getIdCard());
        customerDetails.setPhone(customerUpdate.getPhone());
        return customerService.saveCustomer(customerDetails);
    }


}
