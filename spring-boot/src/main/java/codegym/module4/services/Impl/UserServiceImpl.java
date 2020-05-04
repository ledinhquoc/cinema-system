package codegym.module4.services.Impl;

import codegym.module4.entities.User;
import codegym.module4.repositories.UserRepo;
import codegym.module4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> findAll()
    {
        return userRepo.findAll();
    }

    @Override
    public User save(User user)
    {
        return userRepo.save(user);
    }
}
