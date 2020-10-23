package com.sidenis.banking.task.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum RequestType {
    TRANSFER("Transfer"),
    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw"),
    BALANCE("Balance");

    String type;

    RequestType(String s) {
        type = s;
    }
}


