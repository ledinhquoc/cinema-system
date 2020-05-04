package codegym.module4.services;

import codegym.module4.entities.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer findById(int id);
}
