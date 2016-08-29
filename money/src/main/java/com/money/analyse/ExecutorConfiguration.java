package com.money.analyse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.money.analyse.task.BaseTask;
import com.money.analyse.task.ext.CountNumberTask;
import com.money.analyse.task.ext.GeneticTask;

@Configuration
public class ExecutorConfiguration {

	@Bean
	public List<BaseTask> taskList() {
		List<BaseTask> taskList = new ArrayList<BaseTask>();
		taskList.add(countNumberTask());
		taskList.add(geneticTask());
		return taskList;
	}

	@Bean
	public BaseTask countNumberTask() {
		return new CountNumberTask();
	}

	@Bean
	public BaseTask geneticTask() {
		return new GeneticTask();
	}
}
