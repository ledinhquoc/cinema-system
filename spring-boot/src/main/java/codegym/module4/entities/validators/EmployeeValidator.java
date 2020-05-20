package codegym.module4.entities.validators;

import codegym.module4.controllers.RestController;
import codegym.module4.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator
{
    public static enum Mode
    {
        ADD, EDIT
    }

    ;
    public Mode mode;

    @Autowired
    private RestController restController;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Employee newEmployee = (Employee) target;
        Employee oldEmployee = restController.getEmployeeById(newEmployee.getId());
        Boolean isNotChangedPassword=false;

        if (mode == Mode.EDIT)
        {
            isNotChangedPassword = newEmployee.getUsers().getPassword().equals(oldEmployee.getUsers().getPassword());
        }

        if (newEmployee.getFullName().matches("^[\\s]*$")) //incorrect pattern
        {
            errors.rejectValue("fullName", "fullName.required");
        } else if (!newEmployee.getFullName().matches("^\\X+[\\s]?\\X+[\\D]+$")) //corrected pattern
        {
            errors.rejectValue("fullName", "fullName.pattern");
        }

        if (newEmployee.getGender().matches("^[\\s]*$"))
        {
            errors.rejectValue("gender", "gender.required");
        } else if (!(newEmployee.getGender().equals("Male") || newEmployee.getGender().equals("Female")))
        {
            errors.rejectValue("gender", "gender.notMatchDefaults");
        }

        if (newEmployee.getIdCard().matches("^[\\s]*$"))
        {
            errors.rejectValue("idCard", "idCard.required");
        } else if (!newEmployee.getIdCard().matches("^[\\d]{9}$"))
        {
            errors.rejectValue("idCard", "idCard.pattern");
        } else if (!restController.checkUniqueIdCard(newEmployee.getIdCard()))
        {
            if (mode == Mode.ADD)
            {
                errors.rejectValue("idCard", "idCard.takenIdCard");
            }
        }

        if (newEmployee.getEmail().matches("^[\\s]*$"))
        {
            errors.rejectValue("email", "email.required");
        } else if (!newEmployee.getEmail().matches("^[a-zA-Z]{7,20}[\\d]{0,3}\\@[a-zA-Z]{2,5}\\.[a-zA-Z]{2,7}$"))
        {
            errors.rejectValue("email", "email.pattern");
        } else if (!restController.checkUniqueEmail(newEmployee.getEmail()))
        {
            if (mode == Mode.ADD)
            {
                errors.rejectValue("email", "email.takenEmail");
            }
        }

        if (newEmployee.getUsers().getUsername().matches("^[\\s]*$"))
        {
            errors.rejectValue("users", "username.required");
        } else if (!newEmployee.getUsers().getUsername().matches("^[a-zA-Z\\d]{5,15}$"))
        {
            errors.rejectValue("users", "username.pattern");
        } else if (!restController.checkUniqueUsername(newEmployee.getUsers().getUsername()))
        {
            if (mode == Mode.ADD)
            {
                errors.rejectValue("users", "username.takenUsername");
            }
        } else if (mode == Mode.EDIT)
        {
            if (!newEmployee.getUsers().getUsername().equals(oldEmployee.getUsers().getUsername()))
            {
                errors.rejectValue("users", "username.notAcceptable");
            }
        }

        if (newEmployee.getUsers().getPassword().matches("^[\\s]*$") && !isNotChangedPassword)
        {
            errors.rejectValue("users", "password.required");
        } else if (!newEmployee.getUsers().getPassword().matches("^[\\S]{5,15}$") && !isNotChangedPassword)
        {
            errors.rejectValue("users", "password.pattern");
        }

        if (newEmployee.getAddress().matches("^[\\s]*$"))
        {
            errors.rejectValue("address", "address.required");
        }

        if (newEmployee.getPhone().matches("^[\\s]*$"))
        {
            errors.rejectValue("phone", "phone.required");
        } else if (!newEmployee.getPhone().matches("^[\\d]{9,11}$"))
        {
            errors.rejectValue("phone", "phone.pattern");
        }

        if (newEmployee.getDateOfBirth() == null)
        {
            errors.rejectValue("dateOfBirth", "dateOfBirth.required");
        }
    }
}
