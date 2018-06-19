package by.itacademy.service.aspect;

import by.itacademy.entity.BaseEntity;
import by.itacademy.service.interfaces.ServiceInt;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.Serializable;

@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* *by.itacademy.service.*.*.save(..))")
    public void saveLogging() {
    }

    @Pointcut("execution(* *by.itacademy.service.*.*.delete(..))")
    public void deleteLogging() {
    }

    @Pointcut("execution(* *by.itacademy.service.*.*.update(..))")
    public void updateLogging() {
    }

    @Pointcut("execution(* *by.itacademy.service.*.*.findAll(..))")
    public void findAllLogging() {
    }

    @AfterReturning("saveLogging()  && args(object) && this(service)")
    public void afterSaveLogging(BaseEntity<Serializable> object, ServiceInt service) {
        LOGGER.info(service.toString() + " save entity - " + object + "id=" + object.getId());
    }

    @AfterReturning("deleteLogging() && args(object) && this(service)")
    public void afterDeleteLogging(BaseEntity<Serializable> object, ServiceInt service) {
        LOGGER.info(service.toString() + " delete entity - " + object.toString());
    }

    @AfterReturning("updateLogging() && args(object) && this(service)")
    public void afterUpdateLogging(BaseEntity<Serializable> object, ServiceInt service) {
        LOGGER.info(service.toString() + " update object - " + object.toString());
    }

    @AfterReturning("findAllLogging() && this(service)")
    public void afterFindAll(ServiceInt service) {
        LOGGER.info(service.toString() + " find all entity");
    }

}
