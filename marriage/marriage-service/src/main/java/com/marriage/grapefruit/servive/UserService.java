package com.marriage.grapefruit.servive;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.marriage.grapefruit.model.entity.User;

public interface UserService extends UserDetailsService {

    Optional<User> getUserById(Integer id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Integer id);
    
    List<User> list(Map<String, Object> map);

}
