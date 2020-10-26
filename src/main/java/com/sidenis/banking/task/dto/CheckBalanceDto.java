package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sidenis.banking.task.enums.RequestType;

import java.time.LocalDateTime;

@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
public class CheckBalanceDto extends UserRequestDto {
    public CheckBalanceDto() {
        requestType = RequestType.BALANCE;
        requestTime = LocalDateTime.now();
    }
}
