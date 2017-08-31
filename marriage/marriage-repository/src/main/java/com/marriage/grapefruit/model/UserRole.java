package com.marriage.grapefruit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "user_role")
@Getter
@Setter
@ToString
public class UserRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private String roleid;
}
