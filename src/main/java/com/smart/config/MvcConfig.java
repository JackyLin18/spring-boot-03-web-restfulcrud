package com.smart.config;


import com.smart.component.LoginHandlerInterceptor;
import com.smart.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 当浏览器发送 /abc 请求时，来到success页面
//        registry.addViewController("/abc").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("main.html").setViewName("dashboard");
    }

    // 当容器中没有自定义的LocaleResolver时，SpringBoot使用默认的LocaleResolver，
    // 当我们向容器中添加自定义的LocaleResolver时，SpringBoot就使用我们定义的LocaleResolver
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login.html","/user/login","/webjars/**","/asserts/**");
    }*/
}
