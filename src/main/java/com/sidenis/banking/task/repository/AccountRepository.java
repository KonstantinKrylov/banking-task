package com.sidenis.banking.task.repository;

import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
