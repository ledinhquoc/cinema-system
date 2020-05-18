package codegym.module4.services;

import codegym.module4.entities.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer save(Customer customer);
    
    Customer findById(int id);

    Customer findCustomerById(int id);

    Customer findByIdL(int id);

    List<Customer> findAllCustomer();

    List<Customer> saveAll(List<Customer> customers);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void deleteCustomerById(int id);



}
