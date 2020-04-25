package codegym.module4.services.Impl;

import codegym.module4.entities.customer;
import codegym.module4.repositories.CustomerRepository;
import codegym.module4.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements customerService {
@Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public customer findCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public customer saveCustomer(customer customer) {
        return customerRepository.save(customer);
    }
}
