package com.refactorizando.samples.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.refactorizando.samples.dgs.domain.Account;
import com.refactorizando.samples.dgs.domain.Bank;
import com.refactorizando.samples.dgs.domain.User;
import com.refactorizando.samples.dgs.domain.input.AccountInput;
import com.refactorizando.samples.dgs.repository.AccountRepository;
import com.refactorizando.samples.dgs.repository.BankRepository;
import com.refactorizando.samples.dgs.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@DgsComponent
@RequiredArgsConstructor
public class AccountMutation {

    private final AccountRepository accountRepository;

    private final BankRepository bankRepository;

    private final UserRepository userRepository;


    @DgsData(parentType = "MutationResolver", field = "createAccount")
    public Account createAccount(@InputArgument("account") AccountInput account) {
        User user = userRepository.findById(account.getUserId()).orElseThrow(DgsEntityNotFoundException::new);
        Bank bank = bankRepository.findById(account.getBankId()).orElseThrow(DgsEntityNotFoundException::new);
        return accountRepository.save(new Account(null,
                account.getName(), account.getAlias(), account.getAmount(), user, bank));
    }
}