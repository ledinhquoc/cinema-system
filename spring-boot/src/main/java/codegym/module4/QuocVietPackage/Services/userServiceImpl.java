package codegym.module4.QuocVietPackage.Services;

import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Repositories.UserRepository;
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
    public user findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<user> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public user save(user User) {
        return userRepository.save(User);
    }
}
