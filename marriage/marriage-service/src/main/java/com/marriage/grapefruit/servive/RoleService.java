package com.marriage.grapefruit.servive;

import java.util.List;

import com.marriage.grapefruit.model.entity.Role;

public interface RoleService extends BaseService{
	
	List<Role> list(String name);
	
	Role findOne(Integer id);
	
	Role findByName(String name);
}
