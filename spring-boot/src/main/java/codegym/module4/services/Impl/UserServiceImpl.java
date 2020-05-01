package codegym.module4.services.Impl;

import codegym.module4.entities.User;
import codegym.module4.repositories.UserRepo;
import codegym.module4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> findAll()
    {
        return userRepo.findAll();
    }


    @Override
    public User findUserById(Integer id) {
        return userRepo.findById(id).get();
    }


    @Override
    public List<User> findAllUsers() {

        return userRepo.findAll();
    }

    @Override
    public User save(User user) {   return userRepo.save(user);
    }



}

