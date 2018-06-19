package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Import(ConfigurationService.class)
@ComponentScan(basePackages = "by.itacademy")
public class TestConfigurationService {
}
