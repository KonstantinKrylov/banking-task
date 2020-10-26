package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;

import java.time.LocalDateTime;

@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
public class TransactionHistoryDto extends UserRequestDto {
    public TransactionHistoryDto() {
        requestType = RequestType.HiSTORY;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return super.checkNull() &&
                after != null;
    }

    @JsonProperty
    @Override
    public void setAfter(LocalDateTime after) {
        super.setAfter(after);
    }
}
