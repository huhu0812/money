package com.money.repository;

import com.money.entities.MoneyNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface MoneyNumberRepository extends JpaRepository<MoneyNumber, Long> {
}
