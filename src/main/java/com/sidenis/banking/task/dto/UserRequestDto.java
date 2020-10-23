package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty
    protected String destinationAccount;
    @JsonProperty
    protected Boolean isLocal;
    @JsonProperty
    protected Double transactionValue;

    public abstract boolean checkNull();
}
