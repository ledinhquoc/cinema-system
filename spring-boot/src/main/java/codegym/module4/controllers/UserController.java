package codegym.module4.controllers;


import codegym.module4.entities.User;
import codegym.module4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";
    private final UserService userService;
    @Autowired
    PasswordEncoder encoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getAllUser() {
        return userService.findAllUser();
    }


    @GetMapping("/{id}")
    public User getUserByID(@PathVariable int id){
        return userService.findByIdL(id);
    }


    @PutMapping("/{id}")
    public User updateCustomer(@PathVariable int id, @RequestBody User userUpdate){
        User userDetail;
        userDetail = userService.findByIdL(id);
        userDetail.setPassword(userUpdate.getPassword());
        userService.save(userDetail);
        return userService.findByIdL(id);
    }

    @PatchMapping("/updatePassword/{id}/password")
    public User updatePassword(@PathVariable int id, @RequestBody String pass) {
        User user1 = userService.findByIdL(id);
        user1.setPassword(encoder.encode(pass));
        userService.save(user1);
        return userService.findByIdL(id);
    }

    @PatchMapping("/updateStatus/{id}")
    public User updateUser(@PathVariable int id) {
        User user1 = userService.findByIdL(id);
        user1.setStatus(true);
        userService.save(user1);
        return userService.findByIdL(id);
    }

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable("id") int id) {
//        return userService.findByIdL(id);
//    }
}
