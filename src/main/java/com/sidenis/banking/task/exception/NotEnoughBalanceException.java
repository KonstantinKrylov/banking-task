package com.sidenis.banking.task.exception;

public class NotEnoughBalanceException extends Exception{
    public NotEnoughBalanceException(String em) {
        super(em);
    }
}
