package codegym.module4.services;

import codegym.module4.entities.customer;

import java.util.List;

public interface customerService {

    customer findCustomerById(int id);

    List<customer> findAllCustomer();

    customer saveCustomer(customer customer);
}
