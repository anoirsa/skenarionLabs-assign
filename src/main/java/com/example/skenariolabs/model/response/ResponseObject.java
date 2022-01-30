package com.example.skenariolabs.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {
    private boolean error;
    private String errorText;
    private String note;
    private Object data;

    public ResponseObject(Object data) {
        this.data = data;
    }

}
