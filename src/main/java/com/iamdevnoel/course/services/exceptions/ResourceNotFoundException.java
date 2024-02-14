package com.iamdevnoel.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("Resource not found. The id inserted may be invalid: " + id);
    }
}
