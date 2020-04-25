package codegym.module4.Services;

import codegym.module4.Entities.customer;

import java.util.List;

public interface customerService {

    customer findCustomerById(int id);

    List<customer> findAllCustomer();

    customer saveCustomer(customer customer);
}
