package com.marriage.grapefruit.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marriage.grapefruit.model.entity.Role;

public interface RoleRepository {
	
	List<Role> list(@Param("roleName") String name);
	
	Role findOne(@Param("roleId") Integer id);
	
	Role findByName(@Param("roleName") String name);
	
	Integer insertRole(Role role); 
	
	Integer updateRole(Role role);
	
	Integer deleteRole(Role role);
}
