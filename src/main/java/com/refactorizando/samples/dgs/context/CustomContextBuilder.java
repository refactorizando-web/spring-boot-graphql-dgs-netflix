package com.refactorizando.samples.dgs.context;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import com.refactorizando.samples.dgs.domain.Account;
import com.refactorizando.samples.dgs.domain.Bank;
import com.refactorizando.samples.dgs.domain.User;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CustomContextBuilder implements DgsCustomContextBuilder<CustomContext> {

    private List<User> users;

    private  List<Account> accounts;

    private List<Bank> banks;

    public CustomContextBuilder customContext(List<User> users, List<Account> accounts, List<Bank> banks) {
        this.users = users;
        this.accounts = accounts;
        this.banks = banks;
        return this;
    }

    @Override
    public CustomContext build() {
        return new CustomContext(users, accounts, banks);
    }
}
