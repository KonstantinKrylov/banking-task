package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountIdentityDto {
    @JsonProperty
    protected String userFirstName;
    @JsonProperty
    protected String userLastName;
    @JsonProperty
    protected String userPassport;
    @JsonProperty
    protected Long accountId;

    public boolean checkNull(){
        return userFirstName != null &&
                userLastName != null &&
                userPassport != null &&
                accountId != null;
    }
}
