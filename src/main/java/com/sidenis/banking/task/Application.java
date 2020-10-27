package com.sidenis.banking.task;

import com.sidenis.banking.task.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.sidenis")
@EnableJpaRepositories
@EnableTransactionManagement
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private CommissionService commissionService;

    @Scheduled(cron = "0 0 1 1 * *")
    public void scheduleMonthlyCommission() {
        commissionService.chargeMonthlyCommission();
    }

    @Scheduled(cron = "1 1 1 * * *")
    @CacheEvict(value = {"history"})
    public void clearCache() {
    }
}
