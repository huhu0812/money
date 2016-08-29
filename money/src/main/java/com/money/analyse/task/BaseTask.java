package com.money.analyse.task;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.money.entities.AnalyseResult;
import com.money.repository.AnalyseResultRepository;
import com.money.repository.MoneyNumberRepository;
import com.money.repository.OriginalNumberRepository;

@Component("baseTask")
public abstract class BaseTask {

	@Resource
	protected MoneyNumberRepository moneyNumberRepository;

	@Resource
	protected AnalyseResultRepository analyseResultRepository;
	
	@Resource
	protected OriginalNumberRepository originalNumberRepository;

	public abstract void execute(Consumer<List<AnalyseResult>> consumer);
}
