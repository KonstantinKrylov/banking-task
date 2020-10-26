package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class UserRequestDto {
    @JsonIgnore
    protected LocalDateTime requestTime;
    @JsonIgnore
    protected RequestType requestType;
    @JsonProperty
    protected String userFirstName;
    @JsonProperty
    protected String userLastName;
    @JsonProperty
    protected String userPassport;
    @JsonProperty
    protected Long accountId;

    protected Long destinationAccount;
    protected Boolean isLocal;
    protected Double transactionValue;
    protected LocalDateTime after;

    public boolean checkNull(){
        return userFirstName != null &&
                userLastName != null &&
                userPassport != null &&
                accountId != null;
    };
}
