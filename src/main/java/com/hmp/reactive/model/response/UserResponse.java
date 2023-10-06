package com.hmp.reactive.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse<T> implements Serializable {
    private T result;
    private String msg;
    private String statusCode;

}
