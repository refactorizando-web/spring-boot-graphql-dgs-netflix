package com.refactorizando.samples.dgs.repository;

import com.refactorizando.samples.dgs.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
