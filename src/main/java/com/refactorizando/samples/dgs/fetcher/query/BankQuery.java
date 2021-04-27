package com.refactorizando.samples.dgs.fetcher.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.refactorizando.samples.dgs.domain.Bank;
import com.refactorizando.samples.dgs.repository.BankRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@DgsComponent
@RequiredArgsConstructor
public class BankQuery {

    private final BankRepository repository;

    @DgsData(parentType = "QueryResolver", field = "banks")
    public Iterable<Bank> findAll() {
        return repository.findAll();
    }

    @DgsData(parentType = "QueryResolver", field = "bank")
    public Bank findById(@InputArgument("id") String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid).orElseThrow(DgsEntityNotFoundException::new);
    }
}

