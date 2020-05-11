package codegym.module4.services;

import codegym.module4.entities.Employee;

import java.util.List;

public interface EmployeeService
{
    Employee findById(int id);
    List<Employee> findAll();
}
