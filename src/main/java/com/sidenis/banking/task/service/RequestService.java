package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.*;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.exception.NotEnoughBalanceException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.repository.AccountRepository;
import com.sidenis.banking.task.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestService {

    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final TransactionService transactionService;

    @Autowired
    public RequestService(AccountRepository accountRepository, AccountService accountService, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Transactional
    public Account checkBalance(CheckBalanceDto dto) throws NoSuchAccountException{
        Account account = accountService.getAccountIfExists(dto);
        transactionService.createAndSaveTransaction(dto);
        return account;
    }

    @Transactional
    public Account depositMoney(DepositDto dto) throws NoSuchAccountException{
        Account account = accountService.getAccountIfExists(dto);
        account.setBalance(account.getBalance() + dto.getTransactionValue());
        transactionService.createAndSaveTransaction(dto);
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdrawMoney(WithdrawDto dto) throws NotEnoughBalanceException, NoSuchAccountException{
        Account account = accountService.getAccountIfExists(dto);
        accountService.checkIfEnoughBalance(dto, account);
        account.setBalance(account.getBalance() - dto.getTransactionValue());
        transactionService.createAndSaveTransaction(dto);
        return accountRepository.save(account);
    }

    @Transactional
    public Account transferMoney(TransferDto dto) throws NotEnoughBalanceException, NoSuchAccountException{
        Account account = accountService.getAccountIfExists(dto);
        accountService.checkIfEnoughBalance(dto, account);
        account.setBalance(account.getBalance() - dto.getTransactionValue());
        transactionService.createAndSaveTransaction(dto);
        return accountRepository.save(account);
    }

}
