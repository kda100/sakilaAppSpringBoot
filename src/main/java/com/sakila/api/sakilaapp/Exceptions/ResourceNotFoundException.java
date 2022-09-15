package com.sakila.api.sakilaapp.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    final private String resourceName;
    final private String fieldName;
    final private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
