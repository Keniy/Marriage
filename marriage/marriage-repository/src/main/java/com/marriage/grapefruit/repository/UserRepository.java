package com.marriage.grapefruit.repository;

import java.util.List;
import java.util.Map;

import com.marriage.grapefruit.model.entity.User;

public interface UserRepository {

    User selectUserById(Integer id);

    User selectUserByUsername(String username);

    List<User> selectAllUsers();

    Integer insertUser(User user);

    Integer updateUserOnPasswordById(User user);

    Integer deleteUserById(Integer id);
    
    List<User> getByMap(Map<String, Object> map);
    
	List<User> getByRoleId(Map<String, Object> map);
	
	User getById(Integer id);
	
	Integer create(User user);
	
	int update(User user);
	
	User getByUserName(String userName);

}
