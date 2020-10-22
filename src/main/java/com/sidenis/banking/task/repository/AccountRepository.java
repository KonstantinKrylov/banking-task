package com.sidenis.banking.task.repository;

import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByUser_FirstNameAndUser_LastNameAndUser_PassportAndId(String fN, String lN, String p, Long id);
}
