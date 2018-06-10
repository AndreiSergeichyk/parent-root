package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@Import(PersistenceConfig.class)
@ComponentScan(basePackages = {"by.itacademy"})
@Transactional
public class ServicePersistenceConfig {
}
