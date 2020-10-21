package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class AccountDto {
    @JsonProperty
    private Double balance;
    @JsonProperty
    private Boolean isActive;
}
