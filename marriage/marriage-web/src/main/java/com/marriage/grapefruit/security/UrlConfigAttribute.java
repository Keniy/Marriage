package com.marriage.grapefruit.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;

import lombok.Getter;

@SuppressWarnings("serial")
public class UrlConfigAttribute implements ConfigAttribute{
	
	@Getter
	private final HttpServletRequest httpServletRequest;
	
	public UrlConfigAttribute(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
