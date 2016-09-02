package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.money.entities.Red;

@Repository
public interface RedRepository extends JpaRepository<Red, Long> {

	public Red findByNumber(String number);
}
