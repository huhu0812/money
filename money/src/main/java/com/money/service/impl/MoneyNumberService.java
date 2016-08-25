package com.money.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.money.analyse.CountNumberTask;
import com.money.entities.AnalyseResult;
import com.money.entities.MoneyNumber;
import com.money.repository.AnalyseResultRepository;
import com.money.repository.MoneyNumberRepository;
import com.money.service.IMoneyNumberService;
import com.money.utils.enums.AppeareType;

@Service
public class MoneyNumberService implements IMoneyNumberService {

	@Resource
	private MoneyNumberRepository moneyNumberRepository;

	@Resource
	private AnalyseResultRepository analyseResultRepository;

	public void analyseMoney() {
		List<AnalyseResult> results = this.analyseResultRepository.findByType(AppeareType.ALL);
		if (CollectionUtils.isEmpty(results)) {
		} else {

		}
		Sort sort = new Sort(Sort.Direction.DESC, new String[] { "date" });
		Pageable pageable = new PageRequest(0, AppeareType.getMax().getNumber(), sort);
		Page<MoneyNumber> page = this.moneyNumberRepository.findAll(pageable);
		final List<AnalyseResult> analyseResult = new ArrayList<AnalyseResult>();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (AppeareType type : AppeareType.values()) {
			Runnable runnable = new CountNumberTask(page.getContent(), type, new Consumer<AnalyseResult>() {
				public void accept(AnalyseResult t) {
					analyseResult.add(t);
				}
			});
			executorService.execute(runnable);
		}
	}
}
