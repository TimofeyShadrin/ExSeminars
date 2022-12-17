package ru.gb.homework.exception.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gb.homework.exception.service.IArrayService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrayService implements IArrayService {

    @Value(value = "${array-service.exception.array-is-null}")
    private String nullMessage;

    @Value(value = "${array-service.exception.array-is-empty}")
    private String emptyMessage;

    @Value(value = "${array-service.exception.one-element-is-null}")
    private String oneElementNull;

    @Value(value = "${array-service.exception.several-elements-are-null}")
    private String severalElementsNull;

    @Override
    public List<Integer> validateArray(List<Integer> integerList) {
        if (integerList == null) {
            throw new IllegalStateException(nullMessage);
        }
        if (integerList.isEmpty()) {
            throw new IllegalStateException(emptyMessage);
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) == null) {
                indexes.add(i);
            }
        }
        if (indexes.size() == 1) {
            throw new IllegalStateException(oneElementNull);
        } else if (indexes.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder(severalElementsNull)
                    .append(": ");
            for (Integer index : indexes) {
                stringBuilder.append("element with index: ").append(index).append(", ");
            }
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length() - 1, ".");
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            return integerList;
        }
    }
}
