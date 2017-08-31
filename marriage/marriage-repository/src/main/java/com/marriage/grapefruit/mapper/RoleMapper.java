package com.marriage.grapefruit.mapper;

import java.util.List;

import com.marriage.grapefruit.model.Role;
import com.marriage.grapefruit.utils.MarriageMapper;

public interface RoleMapper extends MarriageMapper<Role>{
	
	public List<Role> queryRoleListWithSelected(Integer id);
}
