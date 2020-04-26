package codegym.module4.services.impl;

import codegym.module4.entities.User;
import codegym.module4.repositories.UserRepository;
import codegym.module4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
