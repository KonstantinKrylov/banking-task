package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto extends AccountIdentityDto{

    @JsonProperty
    private Double balance;
    @JsonProperty
    private Boolean isActive;

    @Override
    public boolean checkNull() {
        return balance != null &&
                isActive != null;
    }

}
