package com.sidenis.banking.task.repository;

import com.sidenis.banking.task.model.Account;
import com.sidenis.banking.task.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
    List<Transaction> findByAccountIdAndUserPassportAndTrxDateTimeAfter(Long aId, String ppt, LocalDateTime after);

    @Query(value = "select tr.accountid as aid, sum(tr.trxvalue) as tsum \n" +
            "from (select * from transaction where trxdatetime>:after) tr\n" +
            "group by tr.accountid", nativeQuery = true)
    List<Tuple> calculateMonthlyTrxValue(String after);
}
