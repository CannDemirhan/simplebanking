package com.eteration.simplebanking.config;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final IAccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        accountRepository.save(new Account("Kerem Karaca", "17892"));
    }
}
