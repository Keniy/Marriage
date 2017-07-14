package com.marriage.grapefruit.repository;

import java.util.List;
import java.util.Map;

import com.marriage.grapefruit.model.entity.Permission;

public interface PermissionRepository {
	
	List<Permission> getByMap(Map<String, Object> map);

    Permission getById(Integer id);

    Integer create(Permission permission);

    int update(Permission permission);

    List<Permission> getByUserId(Integer userId);
}
