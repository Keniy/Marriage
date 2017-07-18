package com.marriage.grapefruit.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marriage.grapefruit.model.entity.Permission;
import com.marriage.grapefruit.model.entity.User;
import com.marriage.grapefruit.repository.PermissionRepository;
import com.marriage.grapefruit.repository.UserRepository;

@Service
public class UrlUserService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UrlUserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.getByUserName(userName);
		logger.info("get user by name {}", user);
        if (user != null) {
            List<Permission> permissions = permissionRepository.getByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(permission.getUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            user.setGrantedAuthorities(grantedAuthorities);
            return user;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
	}
	
}
