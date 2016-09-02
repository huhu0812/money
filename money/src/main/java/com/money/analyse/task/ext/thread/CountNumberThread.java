package com.money.analyse.task.ext.thread;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.money.entities.AnalyseResult;
import com.money.entities.MoneyNumber;
import com.money.utils.ConstructUtil;
import com.money.utils.enums.AppeareType;

public class CountNumberThread implements Runnable {

	private ThreadLocal<List<MoneyNumber>> moneyNumberList = new ThreadLocal<List<MoneyNumber>>();

	private ThreadLocal<AppeareType> type = new ThreadLocal<AppeareType>();

	private ThreadLocal<Consumer<AnalyseResult>> consumer = new ThreadLocal<Consumer<AnalyseResult>>();

	private ThreadLocal<Map<String, Integer>> countMap = new ThreadLocal<Map<String, Integer>>() {
		public Map<String, Integer> initialValue() {
			return ConstructUtil.getInitCountMap();
		}
	};

	public CountNumberThread() {
	}

	public CountNumberThread(List<MoneyNumber> moneyNumberList, AppeareType type, Consumer<AnalyseResult> consumer) {
		this.moneyNumberList.set(moneyNumberList);
		this.type.set(type);
		this.consumer.set(consumer);
	}

	public void run() {
		if (this.moneyNumberList.get().size() < this.type.get().getNumber()) {
			return;
		}
		List<MoneyNumber> moneyNumbers = this.moneyNumberList.get().subList(0, this.type.get().getNumber());
		for (MoneyNumber moneyNumber : moneyNumbers) {
			Iterator<Entry<String, Integer>> iter = this.countMap.get().entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, Integer> entry = iter.next();
				try {
					String value = BeanUtils.getProperty(moneyNumber, entry.getKey());
					if (StringUtils.isNotBlank(value)) {
						int count = entry.getValue();
						this.countMap.get().put(entry.getKey(), ++count);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}

		}
		AnalyseResult result = new AnalyseResult();
		result.setType((AppeareType) this.type.get());
		Iterator<Entry<String, Integer>> iter = this.countMap.get().entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			try {
				BeanUtils.setProperty(result, (String) entry.getKey(), entry.getValue());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		this.consumer.get().accept(result);
	}
}
