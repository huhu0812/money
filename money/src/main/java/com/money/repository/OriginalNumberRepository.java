package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.money.entities.OriginalNumber;

@Repository
public interface OriginalNumberRepository extends JpaRepository<OriginalNumber, String> {

	public OriginalNumber findById(Long paramLong);

	public OriginalNumber findByRedCombinedAndBlue(String redCombined, String blue);
}
