package com.refactorizando.samples.dgs.context;

import com.refactorizando.samples.dgs.domain.Account;
import com.refactorizando.samples.dgs.domain.Bank;
import com.refactorizando.samples.dgs.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomContext {

    private List<User> users;

    private List<Account> accounts;

    private List<Bank> banks;
}
