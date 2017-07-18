package com.marriage.grapefruit.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.alibaba.fastjson.JSON;
import com.marriage.grapefruit.model.dto.Error;
import com.marriage.grapefruit.security.UrlUserService;
import com.marriage.grapefruit.utils.MD5Util;


@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UrlUserService urlUserService;
    
    @Autowired
    SessionRegistry sessionRegistry;
    
    private static final String SIGN = "DEFAULT";
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        //禁用CSRF保护
        .csrf().disable()
        .authorizeRequests()
        //任何访问都必须授权
        .anyRequest().fullyAuthenticated()
        //配置那些路径可以不用权限访问
        .mvcMatchers("/login").permitAll()
        .mvcMatchers("/logout").permitAll()
        .and()
        .formLogin()
        //登陆成功后的处理，因为是API的形式所以不用跳转页面
        .successHandler(new RestAuthenticationSuccessHandler())
        //登陆失败后的处理
        .failureHandler(new RestAuthenticationFailedHandler())
        .and()
        //登出后的处理
        .logout().logoutSuccessHandler(new RestLogoutSuccessHandler())
        .and()
        //认证不通过后的处理
        .exceptionHandling()
        .authenticationEntryPoint(new RestAuthenticationEntryPoint())
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword, SIGN);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword, SIGN));
            }
        });
    }

    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry=new SessionRegistryImpl();
        return sessionRegistry;
    }
    
    /**
     * 登陆成功后的处理
     */
    public static class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws ServletException, IOException {

            clearAuthenticationAttributes(request);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Error error = new Error();
            error.setCode(0);
            error.setMessage("登录成功");
            out.println(JSON.toJSONString(error));
            out.flush();
            out.close();
            
        }
    }
    
    /**
     * 登录失败操作
     * @author liugy
     *
     */
    public static class RestAuthenticationFailedHandler extends SimpleUrlAuthenticationFailureHandler {

		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Error error = new Error();
            error.setCode(-1);
            error.setMessage("登录失败");
            out.println(JSON.toJSONString(error));
            out.flush();
            out.close();
		}
    	
    }

    /**
     * 登出成功后的处理
     */
    public static class RestLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            //Do nothing!
        	logger.info("user logout success");
//        	super.onLogoutSuccess(request, response, authentication);
        }
    }

    /**
     * 权限不通过的处理
     */
    public static class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request,
                             HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Authentication Failed: " + authException.getMessage());
        }
    }
}