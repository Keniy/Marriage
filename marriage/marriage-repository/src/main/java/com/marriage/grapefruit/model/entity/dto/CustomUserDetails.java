//package com.marriage.grapefruit.model.entity.dto;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.marriage.grapefruit.model.entity.User;
//
//import lombok.Getter;
//import lombok.ToString;
//
//@Getter
//@ToString
//public class CustomUserDetails extends User implements UserDetails {
//
//    private static final long serialVersionUID = 1702923242319850756L;
//
//    private final boolean enabled;
//    private final boolean accountNonExpired;
//    private final boolean credentialsNonExpired;
//    private final boolean accountNonLocked;
//    private final Set<GrantedAuthority> authorities;
//
//    public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        if (user != null
//                && !StringUtils.isBlank(user.getUsername())
//                && !StringUtils.isBlank(user.getPassword())) {
//            setUserName(user.getUsername());
//            setPassword(user.getPassword());
//            this.enabled = enabled;
//            this.accountNonExpired = accountNonExpired;
//            this.credentialsNonExpired = credentialsNonExpired;
//            this.accountNonLocked = accountNonLocked;
//            this.authorities = Collections.unmodifiableSet(new HashSet<>(CollectionUtils.emptyIfNull(authorities)));
//        } else {
//            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
//        }
//    }
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
