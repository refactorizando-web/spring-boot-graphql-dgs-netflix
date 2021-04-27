package com.refactorizando.samples.dgs.repository;

import com.refactorizando.samples.dgs.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {

}
