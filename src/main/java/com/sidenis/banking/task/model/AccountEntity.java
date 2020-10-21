package com.sidenis.banking.task.model;

import com.sidenis.banking.task.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AccountEntity extends Persistable {
    protected AccountType accountType;
}
