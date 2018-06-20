package by.itacademy.config;

import by.itacademy.service.aspect.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Import(PersistenceConfig.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"by.itacademy.service", "by.itacademy.converter", "by.itacademy.service.aspect"})
public class ConfigurationService {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}

