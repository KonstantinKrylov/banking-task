package com.sidenis.banking.task.dto;

import com.sidenis.banking.task.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WithdrawDto extends UserRequestDto {
    public WithdrawDto() {
        requestType = RequestType.WITHDRAW;
        requestTime = LocalDateTime.now();
    }

    @Override
    public boolean checkNull() {
        return userFirstName != null &&
                userLastName != null &&
                userPassport != null &&
                accountId != null &&
                transactionValue != null;
    }
}
