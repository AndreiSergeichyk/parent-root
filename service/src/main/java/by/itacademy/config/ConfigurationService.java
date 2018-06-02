package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Import(PersistenceConfig.class)
@ComponentScan(basePackages = "by.itacademy.service")
public class ConfigurationService {
}
