package codegym.module4.QuocVietPackage.Controllers;


import codegym.module4.QuocVietPackage.Entities.customer;
import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Services.customerService;
import codegym.module4.QuocVietPackage.Services.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final customerService customerService;



    public CustomerController(customerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<customer> getAllUser() {
        return customerService.findAllCustomer();
    }

    @GetMapping("/{id}")
    public customer getUserByID(@PathVariable int id){
        return customerService.findCustomerById(id);
    }


    @PutMapping("/{id}")
    public customer updateCustomer(@PathVariable int id, @RequestBody customer customerUpdate){
        customer customerDetails = customerService.findCustomerById(id);
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

}
