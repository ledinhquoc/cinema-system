package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.customer;

import java.util.List;

public interface customerService {

    customer findCustomerById(int id);

    List<customer> findAllCustomer();

    customer saveCustomer(customer customer);
}
