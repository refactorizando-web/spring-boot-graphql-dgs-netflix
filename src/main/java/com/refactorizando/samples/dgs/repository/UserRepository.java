package com.refactorizando.samples.dgs.repository;

import com.refactorizando.samples.dgs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
