package com.money.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.money.entities.MoneyNumber;

public abstract interface MoneyNumberRepository extends JpaRepository<MoneyNumber, Long> {

	@Query("select moneyNumber from MoneyNumber moneyNumber order by moneyNumber.index desc")
	public Page<MoneyNumber> queryLastOne(Pageable pageable);

}
