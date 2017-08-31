package com.marriage.grapefruit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "role_resources")
@Getter
@Setter
@ToString
public class RoleResources implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "roleId")
    private Integer roleid;

    @Id
    @Column(name = "resourcesId")
    private String resourcesid;
}
