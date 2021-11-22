package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.User;
import com.codegym.casestudy.repository.IUserRepository;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUserRole(Long user_id, Long role_id) {
        userRepository.addUserRole(user_id, role_id);
    }

    @Override
    public void addUserRoleMultiple(Long user_id, Long role_id_1, Long role_id_2) {
        userRepository.addUserRoleMultiple(user_id, role_id_1, role_id_2);
    }
}
