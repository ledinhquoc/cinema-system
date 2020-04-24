package codegym.module4.QuocVietPackage.Controllers;


import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Repositories.UserRepository;
import codegym.module4.QuocVietPackage.Services.userService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final userService userService;

    public UserController(codegym.module4.QuocVietPackage.Services.userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<user> getAllUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public user getUserByID(@PathVariable Long id){
        return userService.findUserById(id);
    }


    @PutMapping("/{id}")
    public user updateUser(@PathVariable Long id, @RequestBody user userUpdate){
        user userDetails= userService.findUserById(id);


        userDetails.setAddress(userUpdate.getAddress());
        userDetails.setBirthday(userUpdate.getBirthday());
        userDetails.setEmail(userUpdate.getEmail());
        userDetails.setFullName(userUpdate.getFullName());
        userDetails.setGender(userUpdate.getGender());
        userDetails.setIdCard(userUpdate.getIdCard());
        userDetails.setPhone(userUpdate.getPhone());
        userDetails.setPassword(userUpdate.getPassword());
        userDetails.setIdCard(userUpdate.getIdCard());

      return   userService.save(userDetails);

    }

}
