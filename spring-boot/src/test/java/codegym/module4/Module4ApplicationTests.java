package codegym.module4;

import codegym.module4.controllers.RestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class Module4ApplicationTests{
    @Autowired
    private RestController restController;
    @Test
    void contextLoads(){
    }

    @Test
    void ControllerTest(){
        assertEquals(2,restController.statisticMoviesBySoldTickets().size(),"Not as expected");
    }
}
