package com.money.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.money.entities.AnalyseResult;
import com.money.utils.enums.AppeareType;

public abstract interface AnalyseResultRepository extends JpaRepository<AnalyseResult, Long> {

	public List<AnalyseResult> findByType(AppeareType paramAppeareType);

	@Query("select count(originalNumber.r01) as r01,count(originalNumber.r02) as r02,count(originalNumber.r03) as r03,"
			+ "count(originalNumber.r04) as r04,count(originalNumber.r05) as r05 ,count(originalNumber.r06) as r06,"
			+ "count(originalNumber.r07) as r07,count(originalNumber.r08) as r08 ,count(originalNumber.r09) as r09, "
			+ "count(originalNumber.r10) as r10,count(originalNumber.r11) as r11,count(originalNumber.r12) as r12,"
			+ "count(originalNumber.r13) as r13,count(originalNumber.r14) as r14,count(originalNumber.r15) as r15 ,"
			+ "count(originalNumber.r16) as r16,count(originalNumber.r17) as r17,count(originalNumber.r18) as r18 ,"
			+ "count(originalNumber.r19) as r19, count(originalNumber.r20) as r20,count(originalNumber.r21) as r21,"
			+ "count(originalNumber.r22) as r22,count(originalNumber.r23) as r23,count(originalNumber.r24) as r24,"
			+ "count(originalNumber.r25) as r25 ,count(originalNumber.r26) as r26,count(originalNumber.r27) as r27,"
			+ "count(originalNumber.r28) as r28 ,count(originalNumber.r29) as r29, count(originalNumber.r30) as r30,"
			+ "count(originalNumber.r31) as r31,count(originalNumber.r32) as r32,count(originalNumber.r33) as r33,"
			+ "count(originalNumber.b01) as b01,count(originalNumber.b02) as b02,count(originalNumber.r03) as b03,"
			+ "count(originalNumber.b04) as r04,count(originalNumber.b05) as r05 ,count(originalNumber.b06) as r06,"
			+ "count(originalNumber.b07) as r07,count(originalNumber.b08) as r08 ,count(originalNumber.b09) as r09, "
			+ "count(originalNumber.b10) as r10,count(originalNumber.b11) as r11,count(originalNumber.b12) as r12,"
			+ "count(originalNumber.b13) as r13,count(originalNumber.b14) as r14,count(originalNumber.b15) as r15 ,"
			+ "count(originalNumber.b16) as r16 from OriginalNumber originalNumber")
	public List<Object[]> queryEach();

}
