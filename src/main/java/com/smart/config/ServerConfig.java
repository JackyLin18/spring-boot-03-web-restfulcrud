package com.smart.config;

import com.smart.filter.MyFilter;
import com.smart.listener.MyListener;
import com.smart.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class ServerConfig {

    /*
        注册三大组件：Servlet, Filter, Listener
     */
    // 注册编写的Servlet
    @Bean
    public ServletRegistrationBean myServlet() {
        // 两个入参：第一个为自己编写的Servlet类实例，第二个为映射路径
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }
    // 注册编写的Filter
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }
    // 注册编写的Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }

    // 配置嵌入式的Servlet容器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            // 定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8888);
            }
        };
    }
}
