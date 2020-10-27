package com.sidenis.banking.task.service;

import com.sidenis.banking.task.dto.UserRequestDto;
import com.sidenis.banking.task.model.Transaction;
import com.sidenis.banking.task.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CommissionService commissionService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CommissionService commissionService) {
        this.transactionRepository = transactionRepository;
        this.commissionService = commissionService;
    }

    @Transactional
    public Transaction createAndSaveTransaction(UserRequestDto dto) {
        Transaction transaction = getTransaction(dto);
        return transactionRepository.save(transaction);
    }

    @Cacheable(value = "history", key = "#dto.accountId")
    public List<Transaction> getHistory(UserRequestDto dto) {
        return transactionRepository.findByAccountIdAndUserPassportAndTrxDateTimeAfter(dto.getAccountId(),
                dto.getUserPassport(),
                dto.getAfter());
    }

    private Transaction getTransaction(UserRequestDto dto) {
        Transaction transaction = null;

        switch (dto.getRequestType()) {
            case BALANCE:
                transaction = returnBalanceTransaction(dto);
                break;
            case TRANSFER:
                transaction = returnTransferTransaction(dto);
                break;
            case WITHDRAW:
                transaction = returnWithdrawTransaction(dto);
                break;
            case DEPOSIT:
                transaction = returnDepositTransaction(dto);
                break;
        }

        return transaction;
    }

    private Transaction returnBalanceTransaction(UserRequestDto dto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(dto.getAccountId());
        transaction.setIsLocal(true);
        transaction.setRequestType(dto.getRequestType().getType());
        transaction.setUserPassport(dto.getUserPassport());
        transaction.setTrxValue(0.0);
        transaction.setCommission(0.0);
        return transaction;
    }

    private Transaction returnTransferTransaction(UserRequestDto dto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(dto.getAccountId());
        transaction.setIsLocal(dto.getIsLocal());
        transaction.setRequestType(dto.getRequestType().getType());
        transaction.setUserPassport(dto.getUserPassport());
        transaction.setTrxValue(dto.getTransactionValue());
        transaction.setCommission(commissionService.calculateTrxCommission(dto));
        transaction.setDestinationAccount(dto.getDestinationAccount().getAccountId());
        return transaction;
    }

    private Transaction returnWithdrawTransaction(UserRequestDto dto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(dto.getAccountId());
        transaction.setIsLocal(true);
        transaction.setRequestType(dto.getRequestType().getType());
        transaction.setUserPassport(dto.getUserPassport());
        transaction.setTrxValue(dto.getTransactionValue());
        transaction.setCommission(0.0);
        return transaction;
    }

    private Transaction returnDepositTransaction(UserRequestDto dto) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(dto.getAccountId());
        transaction.setIsLocal(true);
        transaction.setRequestType(dto.getRequestType().getType());
        transaction.setUserPassport(dto.getUserPassport());
        transaction.setTrxValue(dto.getTransactionValue());
        transaction.setCommission(0.0);
        return transaction;
    }
}

