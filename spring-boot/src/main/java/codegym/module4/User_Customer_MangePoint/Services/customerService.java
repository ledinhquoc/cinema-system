package codegym.module4.User_Customer_MangePoint.Services;

import codegym.module4.User_Customer_MangePoint.Entities.customer;

import java.util.List;

public interface customerService {

    customer findCustomerById(int id);

    List<customer> findAllCustomer();

    customer saveCustomer(customer customer);
}
