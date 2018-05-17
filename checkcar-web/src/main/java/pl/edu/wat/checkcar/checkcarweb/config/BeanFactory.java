package pl.edu.wat.checkcar.checkcarweb.config;

import com.github.ggeorgovassilis.springjsonmapper.spring.SpringRestInvokerProxyFactoryBean;
import groovy.lang.Singleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wat.checkcar.checkcardomain.rest.TestRest;



/**
 * Created by Aleksander Małkowicz, Date: 17.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Configuration
@Singleton
public class BeanFactory {

    @Value(value = "${engine.base.url}")
    String engineBaseUrl;

    private SpringRestInvokerProxyFactoryBean getRestInvoker(Class<?> clazz){
        SpringRestInvokerProxyFactoryBean factory = new SpringRestInvokerProxyFactoryBean();
        factory.setBaseUrl(engineBaseUrl);
        factory.setRemoteServiceInterfaceClass(clazz);
        return factory;
    }

    @Bean(name = "TestRest")
    public SpringRestInvokerProxyFactoryBean testRestClient(){
        return getRestInvoker(TestRest.class);
    }

}
