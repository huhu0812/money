package com.money.analyse.task.ext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import com.money.analyse.task.BaseTask;
import com.money.entities.AnalyseResult;
import com.money.entities.Red;
import com.money.utils.Constants;
import com.money.utils.ConstructUtil;
import com.money.utils.cache.Cacheable;
import com.money.utils.enums.AppeareType;

public class GeneticTask extends BaseTask {

	private static double PM = 0.15;

	private List<Entity> current = new ArrayList<Entity>();

	private List<Entity> next = new ArrayList<Entity>();

	private Map<String, Double> priorityMap = new HashMap<String, Double>();

	@Override
	public void execute(Consumer<List<AnalyseResult>> consumer) {
		try {
			initPriority();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		this.constructOriginalEntity();
		int nums = 0;
		do {
			for (int i = 0; i < this.current.size(); i = i + 2) {
				Entity first = current.get(i);
				if (i == (this.current.size() - 1)) {
					this.next.add(first);
				} else {
					Entity second = current.get(i + 1);
					first.exchange(second);
					first.mutation();
					second.mutation();
					if (first.getPriority().compareTo(second.getPriority()) > 0) {
						this.next.add(first);
					} else if (first.getPriority().compareTo(second.getPriority()) < 0) {
						this.next.add(second);
					} else {
						this.next.add(first);
						this.next.add(second);
					}
				}
			}
			this.current = new ArrayList<Entity>(this.next);
			this.next = new ArrayList<Entity>();
			nums++;
		} while (this.current.size() > 1 || nums < 100000);
		List<AnalyseResult> result = new ArrayList<AnalyseResult>();
		for (Entity entity : this.current) {
			result.add(entity.getResult());
		}
		consumer.accept(result);
	}

	private void initPriority() throws Exception {
		List<AnalyseResult> analyseResults = this.analyseResultRepository.findByType(AppeareType.ALL);
		if (CollectionUtils.isEmpty(analyseResults)) {
			throw new Exception();
		}
		Map<String, String> redValueMap = ConstructUtil.getRedValue(analyseResults.get(0));
		double sum = 0;
		Iterator<Entry<String, String>> iter = redValueMap.entrySet().iterator();
		while (iter.hasNext()) {
			sum += Double.valueOf(iter.next().getValue());
		}
		iter = redValueMap.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			this.priorityMap.put(entry.getKey(), Double.valueOf(entry.getValue()) / sum * 10000);
		}

	}

	public void constructOriginalEntity() {
		List<Red> originalNumberList = this.redRepository.findAll();
		for (Red moneyNumber : originalNumberList) {
			this.current.add(new Entity(moneyNumber));
		}
		current.stream().sorted(new Comparator<Entity>() {
			public int compare(Entity o1, Entity o2) {
				return o1.priority.compareTo(o2.priority);
			}
		});
	}

	private class Entity implements Cacheable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		List<Integer> numbers = new ArrayList<Integer>(6);
		List<Double> prioritys = new ArrayList<Double>(6);
		private Double priority = 0.0;

		public Entity(Red red) {
			for (String redNumber : red.getNumbers()) {
				String field = "r" + redNumber;
				numbers.add(Integer.valueOf(redNumber));
				this.priority += priorityMap.get(field);
				prioritys.add(priorityMap.get(field));
			}
		}

		public Double getPriority() {
			this.priority = 0.0;
			for (Double temp : this.prioritys) {
				this.priority += temp;
			}
			return priority;
		}

		public String getKey() {
			return numbers.toString();
		}

		public void exchange(Entity target) {
			for (int i = 0; i < this.numbers.size(); i++) {
				if (i % 2 == 1) {
					Integer tempNumber = this.numbers.get(i);
					Double tempPriority = this.prioritys.get(i);
					if (target.numbers.contains(tempNumber) || this.numbers.contains(target.numbers.get(i))) {
						continue;
					}
					this.numbers.set(i, target.numbers.get(i));
					this.prioritys.set(i, target.prioritys.get(i));

					target.numbers.set(i, tempNumber);
					target.prioritys.set(i, tempPriority);
				}
			}
		}

		public void mutation() {
			Double randomValue = Math.random();
			if (randomValue >= PM) {
				return;
			}
			int index = (int) (Math.random() * 100 % 6);
			int valueIndex;
			int value;
			do {
				valueIndex = (int) (Math.random() * 1000 % Constants.RED.length);
				value = Integer.valueOf(Constants.RED[valueIndex]);
			} while (this.numbers.contains(value));
			this.numbers.set(index, value);
			this.prioritys.set(index, priorityMap.get("r" + Constants.RED[valueIndex]));
		}

		public AnalyseResult getResult() {
			AnalyseResult result = new AnalyseResult();
			result.setType(AppeareType.GENETIC);
			for (int i = 0; i < this.numbers.size(); i++) {
				Integer number = this.numbers.get(i);
				Double value = this.prioritys.get(i);
				try {
					BeanUtils.setProperty(result, "r" + Constants.RED[number - 1], value);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}
}
