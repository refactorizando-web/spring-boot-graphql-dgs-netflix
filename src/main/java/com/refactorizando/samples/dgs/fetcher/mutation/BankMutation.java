package com.refactorizando.samples.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.refactorizando.samples.dgs.domain.Bank;
import com.refactorizando.samples.dgs.domain.input.BankInput;
import com.refactorizando.samples.dgs.repository.BankRepository;
import lombok.RequiredArgsConstructor;


@DgsComponent
@RequiredArgsConstructor
public class BankMutation {

    private final BankRepository repository;

    @DgsData(parentType = "MutationResolver", field = "createBank")
    public Bank createBank(@InputArgument BankInput bank) {
        return repository.save(new Bank(null, bank.getName(), bank.getCountry(), null, null));
    }

}
