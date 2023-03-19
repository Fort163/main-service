package org.fort.service;

import lombok.AllArgsConstructor;
import org.fort.entity.UserEntity;
import org.fort.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
