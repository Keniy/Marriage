package com.marriage.grapefruit.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 7698862379923111158L;

    private Integer id;
    private String userName;
    private String nickName;
    @JsonIgnore
    private String password;
    private String rePassword;
    private String historyPassword;
    private String mobilePhone;
    private String sign;
    private String wechat;
    private String address;
    private String email;
    
    private Role role;
    private Integer roleId;
    private List<? extends GrantedAuthority> grantedAuthorities;
    
    @JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public String getUsername() {
		return userName;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}
    
}
