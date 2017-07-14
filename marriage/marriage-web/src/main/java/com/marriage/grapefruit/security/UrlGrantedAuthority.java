package com.marriage.grapefruit.security;


import org.springframework.security.core.GrantedAuthority;


import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UrlGrantedAuthority implements GrantedAuthority{
	
	private String url;
	private String method;

	public UrlGrantedAuthority (String permissionUrl, String method) {
        this.url = permissionUrl;
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.url + ";"+this.method;
    }

}
