package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;

import java.time.LocalDateTime;

@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
public class WithdrawDto extends UserRequestDto {
    public WithdrawDto() {
        requestType = RequestType.WITHDRAW;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return super.checkNull() &&
                transactionValue != null;
    }

    @JsonProperty
    @Override
    public void setTransactionValue(Double transactionValue) {
        super.setTransactionValue(transactionValue);
    }
}
