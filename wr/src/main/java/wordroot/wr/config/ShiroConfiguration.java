package wordroot.wr.config;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Filter;

/**
 * @author wuliang
 * @date 2020/8/1
 * 安全措施
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor(){
        return  new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        Map<String, Filter> customizedFilter = new HashMap<>(); // 自定义过滤器1
        return  shiroFilterFactoryBean;
    }

    @Bean
    public  SecurityManager securityManager(){
        
    }
}
