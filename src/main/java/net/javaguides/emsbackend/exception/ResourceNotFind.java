package net.javaguides.emsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFind extends RuntimeException{

    public ResourceNotFind(String message){
        super(message);
    }
}


