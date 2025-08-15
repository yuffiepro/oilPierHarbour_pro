package com.oilpierharbour.platform.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 自定义UserDetailsService实现
 * 实际项目中应该从数据库查询用户信息
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里简单实现，实际项目中应该从数据库查询
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa") // 123456
                    .authorities(Arrays.asList(
                            new SimpleGrantedAuthority("ROLE_ADMIN"),
                            new SimpleGrantedAuthority("ROLE_USER")
                    ))
                    .build();
        } else if ("user".equals(username)) {
            return User.builder()
                    .username("user")
                    .password("$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa") // 123456
                    .authorities(Arrays.asList(
                            new SimpleGrantedAuthority("ROLE_USER")
                    ))
                    .build();
        }
        
        throw new UsernameNotFoundException("用户不存在: " + username);
    }
}

