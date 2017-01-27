package com.devendra.gateway.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by devendra on 27/01/2017.
 */
public class ErrorMessage {

    private List<String> errors;


    public ErrorMessage() {
    }


    public ErrorMessage(List<String> errors) {
        this.errors = errors;
    }


    public ErrorMessage(String error) {
        this(Collections.singletonList(error));
    }


    public ErrorMessage(String... errors) {
        this(Arrays.asList(errors));
    }


    public List<String> getErrors() {
        return errors;
    }


    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
