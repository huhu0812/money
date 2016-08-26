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

import com.money.analyse.task.ext.thread.CountNumberThread;
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

	}
}
