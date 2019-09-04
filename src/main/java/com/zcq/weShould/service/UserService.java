package com.zcq.weShould.service;

import com.zcq.weShould.entity.User;
import com.zcq.weShould.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}
