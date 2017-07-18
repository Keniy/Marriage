package com.marriage.grapefruit.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marriage.grapefruit.model.entity.User;
import com.marriage.grapefruit.servive.UserService;

@RequestMapping(value = "/api/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		return userService.list(map);
    }
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User findOne(@PathVariable Integer userId){
		return userService.getUserById(userId).get();
	}
}
