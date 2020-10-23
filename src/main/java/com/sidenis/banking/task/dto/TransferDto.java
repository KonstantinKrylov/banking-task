package com.sidenis.banking.task.dto;

import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferDto extends UserRequestDto {
    public TransferDto() {
        requestType = RequestType.TRANSFER;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return userFirstName != null &&
                userLastName != null &&
                userPassport != null &&
                accountId != null &&
                transactionValue != null &&
                isLocal != null &&
                destinationAccount != null;

    }
}
