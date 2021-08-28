package com.github.ivpal.realtime.search.users.repository;

import com.github.ivpal.realtime.search.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
