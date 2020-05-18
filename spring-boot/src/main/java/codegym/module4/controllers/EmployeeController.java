package codegym.module4.controllers;

import codegym.module4.entities.Employee;
import codegym.module4.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {
    public static final String BASE_URL = "employees";

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAll() {
        System.out.println("abc");
        return employeeService.findAll();
    }


    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PutMapping(path = "/edit")
    public List<Employee> editAll(@RequestBody List<Employee> employees){
        System.out.println(employees);
        return (List<Employee>) employeeService.saveAll(employees);
    }

    @PostMapping(path = "/add")
    public List<Employee> saveAll(@RequestBody List<Employee> employees){
        System.out.println(employees);
        return (List<Employee>) employeeService.saveAll(employees);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void newCustomer(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
    }
}
