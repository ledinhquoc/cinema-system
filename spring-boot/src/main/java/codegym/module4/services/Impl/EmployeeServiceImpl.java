package codegym.module4.services.Impl;

import codegym.module4.entities.Employee;
import codegym.module4.repositories.EmployeeRepo;
import codegym.module4.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee findById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeRepo.findAll();
    }

    @Override
    public Employee save(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id)
    {
        employeeRepo.deleteById(id);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepo.delete(employee);
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
       return employeeRepo.saveAll(employees);
    }
}
