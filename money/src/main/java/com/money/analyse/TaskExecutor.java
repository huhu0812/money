package com.money.analyse;

import java.util.ArrayList;
import java.util.List;

import com.money.analyse.task.BaseTask;

public class TaskExecutor {

	private static List<BaseTask> taskList = new ArrayList<BaseTask>();

	static {

	}

	private static class TaskExecutorInner {
		public static final TaskExecutor executor = new TaskExecutor();
	}

	private TaskExecutor() {

	}

	public static final TaskExecutor getInstance() {
		return TaskExecutorInner.executor;
	}

	public void executeTask() {

	}
}
