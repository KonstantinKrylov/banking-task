package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CheckBalanceDto extends UserRequestDto {
    public CheckBalanceDto() {
        requestType = RequestType.BALANCE;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return userFirstName != null &&
                userLastName != null &&
                userPassport != null &&
                accountId != null;
    }
}
