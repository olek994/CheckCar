package pl.edu.wat.checkcar.checkcarsso.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.edu.wat.checkcar.checkcarsso.CheckcarssoApplication;

/**
 * Created by Aleksander on 18.11.2018.
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017r.
 */
@EnableTransactionManagement
@Configuration
@EntityScan(basePackages = {"pl.edu.wat.checkcar.checkcardomain.entity"})
@EnableJpaRepositories(basePackageClasses = CheckcarssoApplication.class,basePackages = {"pl.edu.wat.checkcar.checkcarsso.repository"})
public class JpaConfiguration {
}
