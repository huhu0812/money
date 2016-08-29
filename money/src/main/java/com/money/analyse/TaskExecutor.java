package com.money.analyse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.money.analyse.task.BaseTask;
import com.money.entities.AnalyseResult;
import com.money.repository.AnalyseResultRepository;

@Component
public class TaskExecutor {

	@Resource(name = "taskList")
	private List<BaseTask> taskList;

	@Resource
	private AnalyseResultRepository analyseResultRepository;

	public void executeTask() {
		final List<AnalyseResult> anaylseResults = new ArrayList<AnalyseResult>();
		for (BaseTask task : taskList) {
			try {
				task.execute(new Consumer<List<AnalyseResult>>() {
					public void accept(List<AnalyseResult> t) {
						anaylseResults.addAll(t);
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		analyseResultRepository.save(anaylseResults);
	}
}
