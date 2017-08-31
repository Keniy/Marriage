package com.marriage.grapefruit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Resources implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;


    /**
     * 资源url
     */
    @Column(name = "resUrl")
    private String resurl;

    /**
     * 资源类型   1:菜单    2：按钮
     */
    private Integer type;

    /**
     * 父资源
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 排序
     */
    private Integer sort;

    @Transient
    private String checked;//是否选中
}
