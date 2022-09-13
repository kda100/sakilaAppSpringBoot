package com.Sakila.api.SakilaApp.Helpers;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperHelper {
    static public <T, S> List<T> mapList(List<S> entityList, Class<T> targetClass, ModelMapper modelMapper) {
        return entityList.stream()
                .map(entity -> modelMapper.map(entity, targetClass))
                .collect(Collectors.toList());
    }

    static public <T, S> Page<T> mapPage(Page<S> entityPage, Class<T> targetClass, ModelMapper modelMapper) {
        return new PageImpl<T>(
                entityPage.get().map(entity -> modelMapper.map(entity, targetClass))
                        .collect(Collectors.toList()),
                entityPage.getPageable(),
                entityPage.getTotalElements()
        );
    }
}
