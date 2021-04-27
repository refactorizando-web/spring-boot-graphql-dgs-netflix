package com.refactorizando.samples.dgs.fetcher.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.refactorizando.samples.dgs.domain.Account;
import com.refactorizando.samples.dgs.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@DgsComponent
@RequiredArgsConstructor
public class AccountQuery {

    private final AccountRepository repository;

    @DgsData(parentType = "QueryResolver", field = "accounts")
    public Iterable<Account> findAll() {
        return repository.findAll();
    }

    @DgsData(parentType = "QueryResolver", field = "account")
    public Account findById(@InputArgument("id") String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid).orElseThrow(DgsEntityNotFoundException::new);
    }
}