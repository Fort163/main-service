package org.fort.service;

import lombok.AllArgsConstructor;
import org.fort.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

}
