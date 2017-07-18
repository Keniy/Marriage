package com.marriage.grapefruit.servive.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marriage.grapefruit.model.entity.Role;
import com.marriage.grapefruit.repository.RoleRepository;
import com.marriage.grapefruit.repository.mapper.RoleMapper;
import com.marriage.grapefruit.servive.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> list(String name) {
		return null;
	}

	@Override
	public Role findOne(Integer id) {
		return null;
	}

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
