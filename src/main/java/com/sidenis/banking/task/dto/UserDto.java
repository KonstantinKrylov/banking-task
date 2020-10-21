package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.model.Account;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserDto {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String passport;
    @JsonProperty
    private AccountDto account;
    @JsonProperty
    private Boolean isAdmin;
}
