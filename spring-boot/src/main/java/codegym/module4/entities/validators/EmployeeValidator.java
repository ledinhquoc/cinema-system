package codegym.module4.entities.validators;

import codegym.module4.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Employee employee = (Employee) target;

        if (employee.getFullName().matches("^[\\s]*$")) //incorrect pattern
        {
            errors.rejectValue("fullName", "fullName.required");
        } else if (!employee.getFullName().matches("^\\X+[\\s]?\\X+[\\D]+$")) //corrected pattern
        {
            errors.rejectValue("fullName", "fullName.pattern");
        }

        if (employee.getGender().matches("^[\\s]*$"))
        {
            errors.rejectValue("gender", "gender.required");
        } else if (!(employee.getGender().equals("Male") || employee.getGender().equals("Female")))
        {
            errors.rejectValue("gender", "gender.notMatchDefaults");
        }

        if (employee.getIdCard().matches("^[\\s]*$"))
        {
            errors.rejectValue("idCard", "idCard.required");
        } else if (!employee.getIdCard().matches("^[\\d]{9}$"))
        {
            errors.rejectValue("idCard", "idCard.pattern");
        }

        if (employee.getEmail().matches("^[\\s]*$"))
        {
            errors.rejectValue("email", "email.required");
        } else if (!employee.getEmail().matches("^[a-zA-Z]{7,20}[\\d]{0,3}\\@[a-zA-Z]{2,5}\\.[a-zA-Z]{2,7}$"))
        {
            errors.rejectValue("email", "email.pattern");
        }

        if (employee.getUsers().getUsername().matches("^[\\s]*$"))
        {
            errors.rejectValue("users", "username.required");
        } else if (!employee.getUsers().getUsername().matches("^[a-zA-Z\\d]{5,15}$"))
        {
            errors.rejectValue("users", "username.pattern");
        }

        if (employee.getUsers().getPassword().matches("^[\\s]*$"))
        {
            errors.rejectValue("users", "password.required");
        } else if (!employee.getUsers().getPassword().matches("^[\\S]{5,15}$"))
        {
            errors.rejectValue("users", "password.pattern");
        }

        if (employee.getAddress().matches("^[\\s]*$"))
        {
            errors.rejectValue("address", "address.required");
        }

        if (employee.getPhone().matches("^[\\s]*$"))
        {
            errors.rejectValue("phone", "phone.required");
        } else if (!employee.getPhone().matches("^[\\d]{9,11}$"))
        {
            errors.rejectValue("phone", "phone.pattern");
        }

        if (employee.getDateOfBirth()==null)
        {
            errors.rejectValue("dateOfBirth", "dateOfBirth.required");
        }
    }
}
