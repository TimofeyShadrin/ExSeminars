package ru.gb.homework.exception.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.gb.homework.exception.data.GenerateArray;
import ru.gb.homework.exception.service.impl.ArrayService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut(value = "execution(* ru.gb.homework.exception.service.impl.ArrayService.validateArray(..))")
    private void validateCollectionMethod() {
    }

    @AfterReturning(pointcut = "execution(* ru.gb.homework.exception.data.GenerateArray.createArray(..))",
            returning = "integerList")
    public void afterReturningGenerateCollection(List<Integer> integerList) {
        Logger logger = Logger.getLogger(GenerateArray.class.getName());
        logger.info(integerList.toString());
    }

    @Before(value = "validateCollectionMethod()")
    public void beforeValidateCollection() {
        Logger logger = Logger.getLogger(ArrayService.class.getName());
        logger.info("Validation of collection started");
    }

    @After(value = "validateCollectionMethod()")
    public void afterValidateCollection() {
        Logger logger = Logger.getLogger(ArrayService.class.getName());
        logger.info("Validation of collection finished");
    }

    @AfterReturning(value = "validateCollectionMethod()")
    public void afterReturningValidateCollection() {
        Logger logger = Logger.getLogger(ArrayService.class.getName());
        logger.info("Validation of collection finished successfully");
    }
}
