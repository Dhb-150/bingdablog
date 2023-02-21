package love.dabing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author DHB
 * @version 1.0
 * Create by 2023/1/29 13:09
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * UserDetails就好比我们自行设计系统的用户、账户的概念。他包含了用户名、密码和其对应的授予权限。
     * @return
     */
    //注入新的UserDetailsServiceBean
    @Bean
    public UserDetailsService userDetailsService(){


        //使用最简单基于内存的用户管理实现InMemoryUserDetailsManager。
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User
                .withUsername("user")
                .password("{noop}123456")
                .roles("普通用户")
                .build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //根路径允许所有人访问
                .antMatchers("/").permitAll()
                .antMatchers("/user").hasRole("普通用户")
                .and()
                .formLogin().loginProcessingUrl("/login");
    }
}
