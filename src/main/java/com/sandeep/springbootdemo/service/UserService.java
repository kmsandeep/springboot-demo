package com.sandeep.springbootdemo.service;

import com.sandeep.springbootdemo.dao.UserRepository;
import com.sandeep.springbootdemo.dto.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public void createUser(User user) throws RuntimeException{
        repository.save(user);
        throw new RuntimeException("User can't be added");
    }
    public List<User> getUsers() {
        return repository.findByRole("USER");
    }

    public List<User> getAdmins() {
        return repository.findByRole("ADMIN");
    }
}
