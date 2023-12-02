package com.suhan.user.service;

import com.suhan.user.dao.UserRepository;
import com.suhan.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findUserByUserId(id);
    }

}
