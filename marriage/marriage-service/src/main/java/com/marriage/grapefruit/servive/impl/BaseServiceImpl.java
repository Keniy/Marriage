package com.marriage.grapefruit.servive.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marriage.grapefruit.model.dto.Page;
import com.marriage.grapefruit.repository.BaseRepository;
import com.marriage.grapefruit.servive.BaseService;

@Service
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private BaseRepository baseRepository;

	@Override
	public <T extends Serializable> int save(T entity) {
		return baseRepository.save(entity);
	}

	@Override
	public <T extends Serializable> int deleteById(Class<T> clazz, Serializable id) {
		return baseRepository.deleteById(clazz, id);
	}

	@Override
	public <T extends Serializable> T findById(Class<T> clazz, Serializable id) {
		return baseRepository.findById(clazz, id);
	}

	@Override
	public <T extends Serializable> List<T> listAll(Class<T> clazz) {
		return baseRepository.listAll(clazz);
	}

	@Override
	public <T extends Serializable> Page<T> pageSelect(Class<T> clazz, Page<T> p, String[] attrs, Object[] values) {
		return baseRepository.pageSelect(clazz, p, attrs, values);
	}

	@Override
	public <T extends Serializable> int pageCount(Class<T> clazz, String[] attrs, Object[] values) {
		return baseRepository.pageCount(clazz, attrs, values);
	}

	@Override
	public <T extends Serializable> int countAll(Class<T> clazz) {
		return baseRepository.countAll(clazz);
	}

	@Override
	public List<Map<String, Object>> findByMap(String argument, Map<String, Object> params) {
		return baseRepository.findByMap(argument, params);
	}
	
}
