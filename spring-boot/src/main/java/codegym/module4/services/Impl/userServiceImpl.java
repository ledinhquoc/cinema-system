package codegym.module4.services.Impl;

import codegym.module4.entities.user;
import codegym.module4.repositories.UserRepository;
import codegym.module4.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServiceImpl implements userService {


    @Autowired
    private UserRepository userRepository;

    public userServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public user findUserById(Integer id) {

        return userRepository.findById(id).get();
    }



    @Override
    public List<user> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public user save(user user) {        return userRepository.save(user);
    }
}
