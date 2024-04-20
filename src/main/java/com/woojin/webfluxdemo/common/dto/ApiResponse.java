package com.woojin.webfluxdemo.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ApiResponse {
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer page;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer limit;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
