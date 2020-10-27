package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


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

    public boolean checkNull() {
        return firstName != null &&
                lastName != null &&
                passport != null &&
                account != null &&
                isAdmin != null &&
                account.checkNull();
    }
}
