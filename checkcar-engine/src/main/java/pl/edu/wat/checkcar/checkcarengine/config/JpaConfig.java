package pl.edu.wat.checkcar.checkcarengine.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.edu.wat.checkcar.checkcarengine.CheckcarEngineApplication;

/**
 * Created by Aleksander Małkowicz, Date: 15.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(basePackageClasses = CheckcarEngineApplication.class,basePackages = {"pl.edu.wat.checkcar.checkcarengine.repository"})
@EntityScan(basePackages = {"pl.edu.wat.checkcar.checkcardomain.entity"})
public class JpaConfig {
   //TODO dodać securityContext dla audytora
}
