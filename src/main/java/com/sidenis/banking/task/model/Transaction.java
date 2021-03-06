package com.sidenis.banking.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
public class Transaction extends Persistable {

    public Transaction() {
        this.trxDateTime = LocalDateTime.now();
    }

    @Column
    private LocalDateTime trxDateTime;
    @Column
    private String requestType;
    @Column
    private Boolean isLocal;
    @Column
    private String userPassport;
    @Column
    private Long accountId;
    @Column
    private Double trxValue;
    @Column
    private Double commission;
    @Column
    private Long destinationAccount;
}
