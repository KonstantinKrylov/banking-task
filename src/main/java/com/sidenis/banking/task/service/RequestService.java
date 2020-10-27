package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.DepositDto;
import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.exception.NoSuchAccountException;
import com.sidenis.banking.task.exception.NotEnoughBalanceException;
import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.Transaction;
import com.sidenis.banking.task.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Account checkBalance(UserRequestDto dto) throws NoSuchAccountException {
        Account account = accountService.getAccountIfExists(dto);
        transactionService.createAndSaveTransaction(dto);
        return account;
    }

    @Transactional
    public List<Transaction> getHistory(UserRequestDto dto) throws NoSuchAccountException {
        accountService.getAccountIfExists(dto);
        return transactionService.getHistory(dto);
    }

    @Transactional
    public Account depositMoney(UserRequestDto dto) throws NoSuchAccountException {
        Account account = accountService.getAccountIfExists(dto);
        account.setBalance(account.getBalance() + dto.getTransactionValue());
        transactionService.createAndSaveTransaction(dto);
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdrawMoney(UserRequestDto dto) throws NotEnoughBalanceException, NoSuchAccountException {
        Account account = accountService.getAccountIfExists(dto);
        accountService.checkIfEnoughBalance(dto, account);
        account.setBalance(account.getBalance() - dto.getTransactionValue());
        transactionService.createAndSaveTransaction(dto);
        return accountRepository.save(account);
    }

    @Transactional
    public Account transferMoney(UserRequestDto dto) throws NotEnoughBalanceException, NoSuchAccountException {
        Account source = accountService.getAccountIfExists(dto);
        Account destination = accountService.getAccountIfExists(dto.getDestinationAccount());
        accountService.checkIfEnoughBalance(dto, source);
        Transaction transaction = transactionService.createAndSaveTransaction(dto);
        source.setBalance(source.getBalance() - dto.getTransactionValue() - transaction.getCommission());
        destination.setBalance(destination.getBalance() + dto.getTransactionValue());
        accountRepository.save(destination);

        DepositDto depositDto = new DepositDto();
        depositDto.setTransactionValue(dto.getTransactionValue());
        depositDto.setAccountId(dto.getDestinationAccount().getAccountId());
        depositDto.setUserFirstName(dto.getDestinationAccount().getUserFirstName());
        depositDto.setUserLastName(dto.getDestinationAccount().getUserLastName());
        depositDto.setAccountId(dto.getDestinationAccount().getAccountId());
        transactionService.createAndSaveTransaction(depositDto);

        return accountRepository.save(source);
    }

}
