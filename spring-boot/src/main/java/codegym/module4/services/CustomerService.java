package codegym.module4.services;

import codegym.module4.entities.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer save(Customer customer);
    
    Customer findById(int id);

    Customer findCustomerById(int id);

    Customer findByIdL(Integer id);

    List<Customer> findAllCustomer();

    Customer saveCustomer(Customer customer);


    Customer findByIdC(int id);
//
//    void deleteById(Long id);

    void deleteById(Integer id);

    void deleteCustomer(Customer customer);

    void deleteCustomerById(int id);




}
