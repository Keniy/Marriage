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
public class Permission {
	
	private Integer id;
	private String name;
	private String url;
	private String method;
	private String description;
	private Integer pid;
}
