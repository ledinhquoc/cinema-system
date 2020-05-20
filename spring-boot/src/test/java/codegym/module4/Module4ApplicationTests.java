package codegym.module4;

import codegym.module4.controllers.RestController;
import codegym.module4.entities.Employee;
import codegym.module4.entities.validators.EmployeeValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Module4ApplicationTests
{
    @Autowired
    private RestController restController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeValidator employeeValidator;

    @Test
    void contextLoads()
    {
    }

    @Test
    void PasswordEncoderTest()
    {
        assertAll(() ->
        {
            String test = "";
            for (int i = 1; i < 10; i++)
            {
                test += i;
                System.out.println(test);
                assertNotEquals(passwordEncoder
                                .matches(test, "$2a$10$mEIbCMGnV5g2ws3YlxsiM.JoIkV5fPZ6y1mDqi3qUsI42wCzPQP.C")
                        , "Bingo!!!");
            }
        });
    }

    @Test
    void ControllerTest()
    {
        assertTrue(
            passwordEncoder.matches("vantoan123","$2a$10$t1Do/gMP0QKJ04J99FyBH.RnT7cR9v4AIiv5qquaaPFOyaohsK1i2")
        );
    }

    @Test
    void empFormTest(){
        Employee employee=restController.getEmployeeById(11);
        Errors errors=new DirectFieldBindingResult(employee,"employee");
        employeeValidator.mode= EmployeeValidator.Mode.EDIT;

        employee.setFullName("   ");
        employeeValidator.validate(employee,errors);

        assertEquals(errors.getFieldError("fullName").getCode(),"fullName.required");
    }

}
