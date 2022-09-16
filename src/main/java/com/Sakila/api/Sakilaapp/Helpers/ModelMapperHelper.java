package com.Sakila.api.Sakilaapp.Helpers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@AllArgsConstructor
public class ModelMapperHelper {
    private ModelMapper modelMapper;

    public <T, S> Page<T> mapPage(Page<S> entityPage, Class<T> targetClass) {
        return new PageImpl<>(
                entityPage.get().map(entity -> modelMapper.map(entity, targetClass)).toList(),
                entityPage.getPageable(),
                entityPage.getTotalElements()
        );
    }
}
