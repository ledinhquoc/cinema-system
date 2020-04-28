package codegym.module4.services.Impl;

import codegym.module4.entities.Customer;
import codegym.module4.repositories.CustomerRepo;
import codegym.module4.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Customer> findAll()
    {
        return customerRepo.findAll();
    }
}
