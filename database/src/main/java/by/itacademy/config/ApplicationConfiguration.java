package by.itacademy.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = "by.itacademy")
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Value("classpath:database.properties")
    private Resource databaseResource;

    @Bean
    public DataSource dataSource(@Value("${db.password}") String password,
                                 @Value("${db.driver}") String driverClassName,
                                 @Value("${db.url}") String url,
                                 @Value("${db.user}") String user) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(user);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }

    @Bean
    LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource, Properties hibernateProperties) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("by.itacademy.entity");

        localSessionFactoryBean.setHibernateProperties(hibernateProperties);

        return null;
    }

    @Bean
    public Properties hibernateProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(databaseResource.getInputStream());

        return properties;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }
}
