package com.sidenis.banking.task.repository;

import com.sidenis.banking.task.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByUser_FirstNameAndUser_LastNameAndUser_PassportAndId(String fN, String lN, String p, Long id);

    List<Account> findAllByIdIn(Collection<Long> ids);
}
