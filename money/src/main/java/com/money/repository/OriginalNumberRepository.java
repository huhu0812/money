package com.money.repository;

import com.money.entities.OriginalNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginalNumberRepository extends JpaRepository<OriginalNumber, String> {

	public OriginalNumber findById(Long paramLong);

	public OriginalNumber findByCombinedNumber(String combinedNumber);
}
