package com.sidenis.banking.task.enums;

import lombok.Getter;

@Getter
public enum RequestType {
    TRANSFER("Transfer"),
    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw"),
    BALANCE("Balance"),
    HiSTORY("History");

    String type;

    RequestType(String s) {
        type = s;
    }
}


