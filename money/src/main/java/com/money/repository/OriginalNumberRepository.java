package com.money.repository;

import com.money.entities.OriginalNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface OriginalNumberRepository extends JpaRepository<OriginalNumber, String> {
	public abstract OriginalNumber findById(Long paramLong);
}
