package by.itacademy.util;

import by.itacademy.config.ConfigurationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class ContextUtil {

    public static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ConfigurationService.class);

    public static <T extends Object> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
