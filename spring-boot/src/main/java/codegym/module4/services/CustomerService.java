package codegym.module4.services;

import codegym.module4.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(int id);

    List<Customer> findAllCustomer();

    Customer saveCustomer(Customer customer);


}
