package com.sidenis.banking.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferRequestDto extends UserRequestDto {

    public TransferRequestDto() {
        requestType = RequestType.TRANSFER;
        requestTime = LocalDateTime.now();
    }


    @Override
    public boolean checkNull() {
        return false;
    }
}
