package ru.gb.homework.exception.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import ru.gb.homework.exception.data.GenerateArray;
import ru.gb.homework.exception.service.impl.CollectionService;

import java.util.List;

@Controller
public class TaskController {
    private final CollectionService collectionService;
    private final GenerateArray generateArray;
    @Value(value = "${generate.arraySize}")
    private Integer size;

    @Autowired
    public TaskController(CollectionService collectionService, GenerateArray generateArray) {
        this.generateArray = generateArray;
        this.collectionService = collectionService;
    }

    @PostConstruct
    public void doing() {
        List<Integer> integerList = collectionService.validateCollection(generateArray.createArray(size));
    }
}
