package com.example.skenariolabs.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {
    private boolean error;
    private String errorText;
    private Object data;

    public ResponseObject(Object data) {
        this.data = data;
        this.error = false;
    }

}
