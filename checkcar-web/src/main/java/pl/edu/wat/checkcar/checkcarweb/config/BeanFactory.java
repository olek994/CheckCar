package pl.edu.wat.checkcar.checkcarweb.config;

import com.github.ggeorgovassilis.springjsonmapper.spring.SpringRestInvokerProxyFactoryBean;
import groovy.lang.Singleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wat.checkcar.checkcardomain.rest.CarModelRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarRest;
import pl.edu.wat.checkcar.checkcardomain.rest.CarTypeRest;
import pl.edu.wat.checkcar.checkcardomain.rest.InterestingCarRest;
import pl.edu.wat.checkcar.checkcardomain.rest.MeetingRest;
import pl.edu.wat.checkcar.checkcardomain.rest.MessageRest;
import pl.edu.wat.checkcar.checkcardomain.rest.PersonRest;


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

    @Bean(name = "PersonRest")
    public SpringRestInvokerProxyFactoryBean personRestClient(){
        return getRestInvoker(PersonRest.class);
    }

    @Bean(name = "CarRest")
    public SpringRestInvokerProxyFactoryBean carRestClient(){
        return getRestInvoker(CarRest.class);
    }

    @Bean(name = "CarTypeRest")
    public SpringRestInvokerProxyFactoryBean carTypeRestClient(){
        return getRestInvoker(CarTypeRest.class);
    }


    @Bean(name = "CarModelRest")
    public SpringRestInvokerProxyFactoryBean carModelRestClient(){
        return getRestInvoker(CarModelRest.class);
    }

    @Bean(name = "MeetingRest")
    public SpringRestInvokerProxyFactoryBean meetingRestClient(){
        return getRestInvoker(MeetingRest.class);
    }

    @Bean(name = "MessageRest")
    public SpringRestInvokerProxyFactoryBean messageRestClient(){
        return getRestInvoker(MessageRest.class);
    }

    @Bean(name = "InterestingCarRest")
    public SpringRestInvokerProxyFactoryBean interestingCarRestClient(){
        return getRestInvoker(InterestingCarRest.class);
    }
}
