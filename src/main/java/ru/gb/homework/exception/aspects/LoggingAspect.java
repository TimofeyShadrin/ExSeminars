package ru.gb.homework.exception.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.gb.homework.exception.data.GenerateArray;
import ru.gb.homework.exception.service.impl.CollectionService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut(value = "execution(* ru.gb.homework.exception.service.impl.CollectionService.validateCollection(..))")
    private void validateCollectionMethod() {
    }

    @AfterReturning(pointcut = "execution(* ru.gb.homework.exception.data.GenerateArray.createArray(..))",
            returning = "integerList")
    public void afterReturningGenerateCollection(List<Integer> integerList) {
        Logger logger = Logger.getLogger(GenerateArray.class.getName());
        logger.info("PC have generated this collection: " + integerList.toString());
    }

    @Before(value = "validateCollectionMethod()")
    public void beforeValidateCollection() {
        Logger logger = Logger.getLogger(CollectionService.class.getName());
        logger.info("Validation of collection started");
    }

    @AfterThrowing(value = "validateCollectionMethod()")
    public void afterValidateCollection() {
        Logger logger = Logger.getLogger(CollectionService.class.getName());
        logger.info("Validation of collection finished with exception");
    }

    @AfterReturning(value = "validateCollectionMethod()")
    public void afterReturningValidateCollection() {
        Logger logger = Logger.getLogger(CollectionService.class.getName());
        logger.info("Validation of collection finished successfully");
    }
}
