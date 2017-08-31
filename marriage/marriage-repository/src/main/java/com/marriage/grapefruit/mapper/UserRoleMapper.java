package com.marriage.grapefruit.mapper;

import java.util.List;

import com.marriage.grapefruit.model.UserRole;
import com.marriage.grapefruit.utils.MarriageMapper;

public interface UserRoleMapper extends MarriageMapper<UserRole>{
	
	public List<Integer> findUserIdByRoleId(Integer roleId);
}
