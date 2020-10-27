package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class UserRequestDto extends AccountIdentityDto {
    @JsonIgnore
    protected LocalDateTime requestTime;
    @JsonIgnore
    protected RequestType requestType;

    protected AccountDto destinationAccount;
    protected Boolean isLocal;
    protected Double transactionValue;
    protected LocalDateTime after;

}
