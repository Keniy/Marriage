package com.marriage.grapefruit.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marriage.grapefruit.servive.UserService;

@RequestMapping(value = "/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		return userService.list(map);
    }
}
