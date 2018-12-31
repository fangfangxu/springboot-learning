package com.fangfangxu.AuthenticationManager;

import com.fangfangxu.authenticationProvider.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   // 现在再将刚创建的AuthenticationProvider在与ProviderManager里注册，所有操作就完成了。
   @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                   http .authorizeRequests()//
                   //通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
                   // 例如以上代码指定了/和/home不需要任何认证就可以访问，
                   // 其他的路径都必须通过身份验证。
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
        //通过formLogin()定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login")
                .permitAll()
                .and()
        // 日志放行
                .logout()
                .permitAll();
    }
}
