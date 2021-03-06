package com.example.backend.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean ：第三步
    @Bean
    public ShiroFilterFactoryBean geShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro内置过滤器
        /*
        * anon：无需认证就可以访问
        * authc：必须认证才可以访问
        * user：必须拥有 记住我 功能才可以
        * perms：拥有对某个资源对权限才能使用
        * role：拥有某个角色权限才能访问
        */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/hello","authc");

        //设置过滤器
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登陆页面
        bean.setLoginUrl("/login");

        return bean;
    }

    //DefaultWebSecurityManger ：第二步
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("personRealm") PersonRealm personRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(personRealm);
        return securityManager;
    }

    //创建 realm 对象 需要自定义类：第一步
    @Bean
    public PersonRealm personRealm(){
        return new PersonRealm();
    }
}
