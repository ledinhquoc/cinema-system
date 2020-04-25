package codegym.module4.controllers;


import codegym.module4.entities.user;
import codegym.module4.services.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";
    private final userService userService;


    public UserController(codegym.module4.services.userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<user> getAllUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public user getUserByID(@PathVariable int id){
        return userService.findUserById(id);
    }


    @PutMapping("/{id}")
    public user updateCustomer(@PathVariable int id, @RequestBody user userUpdate){
        user userDetail;
        userDetail = userService.findUserById(id);


        userDetail.setPassword(userUpdate.getPassword());



        return userService.save(userDetail);

    }


}
