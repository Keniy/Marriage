package com.marriage.grapefruit.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role implements Comparable<Role>{
	
	private Integer id;
	private String name;
	private Integer roleLevel;
	private Boolean enable;
	private String description;
	private String menuItems;

	@Override
	public int compareTo(Role o) {
		if(id == o.getId()){
			return 0;
		}else if(id > o.getId()){
			return 1;
		}else{
			return -1;
		}
	}

}
