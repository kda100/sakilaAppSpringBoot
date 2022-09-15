package com.Sakila.api.SakilaApp.Helpers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ModelMapperHelper {
    private ModelMapper modelMapper;

    public <T, S> Page<T> mapPage(Page<S> entityPage, Class<T> targetClass) {
        return new PageImpl<T>(
                entityPage.get().map(entity -> modelMapper.map(entity, targetClass))
                        .collect(Collectors.toList()),
                entityPage.getPageable(),
                entityPage.getTotalElements()
        );
    }
}
