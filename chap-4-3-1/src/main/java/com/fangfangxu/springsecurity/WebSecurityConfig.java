package com.fangfangxu.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
//@EnableWebSecurity//开启Spring Security的功能
//extends WebSecurityConfigurerAdapter
public class WebSecurityConfig  {
    //重写方法来设置一些web安全的细节
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//           http .authorizeRequests()//
//                   //通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
//                   // 例如以上代码指定了/和/home不需要任何认证就可以访问，
//                   // 其他的路径都必须通过身份验证。
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//        //通过formLogin()定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login")
//                .permitAll()
//                .and()
//        // 日志放行
//                .logout()
//                .permitAll();
//    }
//  //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////            auth.inMemoryAuthentication()
////                .withUser("user").password("password").roles("USER");
//        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("xufangfang").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//    }
}
