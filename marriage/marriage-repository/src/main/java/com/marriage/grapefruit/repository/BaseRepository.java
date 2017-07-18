package com.marriage.grapefruit.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.marriage.grapefruit.model.dto.Page;

public interface BaseRepository {
	
	public <T extends Serializable> int save(T entity);
	
	public <T extends Serializable> int deleteById(Class<T> clazz, Serializable id);
	
	public <T extends Serializable> T findById(Class<T> clazz, Serializable id);
	
	public <T extends Serializable> List<T> listAll(Class<T> clazz);
	
	public <T extends Serializable> Page<T> pageSelect(Class<T> clazz, Page<T> p, String[] attrs, Object[] values);
	
	public <T extends Serializable> int pageCount(Class<T> clazz, String[] attrs, Object[] values);
	
	public <T extends Serializable> int countAll(Class<T> clazz);
	
	public List<Map<String, Object>> findByMap(String argument, Map<String, Object> params);
	
	
}
