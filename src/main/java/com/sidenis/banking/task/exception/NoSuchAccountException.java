package com.sidenis.banking.task.exception;

public class NoSuchAccountException extends Exception {
    public NoSuchAccountException(String em) {
        super(em);
    }
}
