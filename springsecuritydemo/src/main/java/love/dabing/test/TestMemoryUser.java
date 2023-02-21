package love.dabing.test;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DHB
 * @version 1.0
 * Create by 2023/1/29 14:57
 */

public class TestMemoryUser {
    public static void main(String[] args) {
        ///**
        // * 使用了InMemoryUserDetailsManager基于内存管理的预置用户身份信息管理和基于用户名
        // * 和密码的DaoAuthenticationProvider来验证我们的用户身份信息。
        // */
        ////UserDetailsService提供预置用户
        //UserDetailsService userDetailsManager = new InMemoryUserDetailsManager();
        ////AuthenticationProvider提供验证服务
        //AuthenticationProvider provider = new DaoAuthenticationProvider();
        //
        ////将预置用户提供给AuthenticationProvider
        //((DaoAuthenticationProvider)provider).setUserDetailsService(userDetailsManager);
        //
        ////创建预置用户
        //((InMemoryUserDetailsManager)userDetailsManager).createUser(User
        //        .withUsername("user1")
        //        .password("{noop}123456")
        //        .roles("普通用户")
        //        .build());
        ////创建Authentication
        //Authentication authentication = new UsernamePasswordAuthenticationToken("user1","123456");
        //Authentication result = provider.authenticate(authentication);
        //System.out.println(result);


        /**
         * 屏蔽与AuthenticationProvider的直接联系，使用ProviderManager
         * 使用了InMemoryUserDetailsManager基于内存管理的预置用户身份信息管理和基于用户名
         * 和密码的DaoAuthenticationProvider来验证我们的用户身份信息。
         */
        //UserDetailsService提供预置用户
        UserDetailsService userDetailsManager = new InMemoryUserDetailsManager();
        List<AuthenticationProvider> providers = new ArrayList<>();

        //AuthenticationProvider提供验证服务
        AuthenticationProvider provider = new DaoAuthenticationProvider();

        providers.add(provider);
        ProviderManager providerManager = new ProviderManager(providers);

        //将预置用户提供给AuthenticationProvider
        ((DaoAuthenticationProvider)provider).setUserDetailsService(userDetailsManager);

        //创建预置用户
        ((InMemoryUserDetailsManager)userDetailsManager).createUser(User
                .withUsername("user1")
                .password("{noop}123456")
                .roles("普通用户")
                .build());
        //创建Authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken("user1","123456");
        Authentication result = providerManager.authenticate(authentication);
        System.out.println(result);

    }
}
