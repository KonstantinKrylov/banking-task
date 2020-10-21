package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class RequestDto {
    @JsonIgnore
    protected LocalDateTime requestTime;
    @JsonIgnore
    protected RequestType requestType;
}
