package com.sidenis.banking.task.repository;

import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}
