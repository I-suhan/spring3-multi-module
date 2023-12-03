package com.suhan.user.service;

import com.suhan.user.repository.UserRepository;
import com.suhan.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id){
        return new User();
    }

}
