package codegym.module4.controllers;


import codegym.module4.entities.User;
import codegym.module4.services.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUser() {
        return userService.findAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserByID(@PathVariable int id){
        return userService.findUserById(id);
    }


    @PutMapping("/{id}")
    public User updateCustomer(@PathVariable int id, @RequestBody User userUpdate){
        User userDetail;
        userDetail = userService.findUserById(id);
        userDetail.setPassword(userUpdate.getPassword());
        return userService.save(userDetail);

    }
}
