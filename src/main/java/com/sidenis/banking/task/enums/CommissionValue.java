package com.sidenis.banking.task.enums;

import lombok.Getter;

@Getter
public enum CommissionValue {
    ZERO(100.0),
    EXCEED(0.0),
    MIDDLE(200.0);

    Double value;

    CommissionValue(Double s) {
        value = s;
    }
}


