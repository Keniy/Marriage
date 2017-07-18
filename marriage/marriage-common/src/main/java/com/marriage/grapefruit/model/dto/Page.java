package com.marriage.grapefruit.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class Page<T> implements Serializable{
	
	private int page = 1;
	private int pageSize = 10;
	private long total;
	private String sort;
	private String order;
	private List<T> data;
	
	public Page() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	public Page(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		if(page < 1)
			return 0;
		return (page - 1) * pageSize;
	}
}
