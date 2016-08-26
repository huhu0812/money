package com.money.analyse.task.ext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.money.analyse.task.BaseTask;
import com.money.entities.AnalyseResult;
import com.money.entities.MoneyNumber;
import com.money.utils.Constants;
import com.money.utils.enums.AppeareType;

public class GeneticTask extends BaseTask {

	private List<Entity> current = new ArrayList<Entity>();

	private List<Entity> next = new ArrayList<Entity>();

	@Override
	public void execute(Consumer<List<AnalyseResult>> consumer) {
		this.constructOriginalEntity();
		for (int i = 0; i < this.current.size(); i = i + 2) {
			Entity first=current.get(i);
			if(i==(this.current.size()-1)){
				this.next.add(first);
			}else{
				Entity secord=current.get(i+1);
				
			}
		}
	}

	public void constructOriginalEntity() {
		List<MoneyNumber> moneyNumberList = this.moneyNumberRepository.findAll();
		List<AnalyseResult> analyseResultList = this.analyseResultRepository.findByType(AppeareType.ALL);
		for (MoneyNumber moneyNumber : moneyNumberList) {
			this.current.add(new Entity(moneyNumber, analyseResultList.get(0)));
		}
		current.stream().sorted(new Comparator<Entity>() {
			public int compare(Entity o1, Entity o2) {
				return o1.priority.compareTo(o2.priority);
			}
		});
	}

	private class Entity {
		List<Integer> numbers = new ArrayList<Integer>(6);
		Integer priority;

		public Entity(MoneyNumber moneyNumber, AnalyseResult analyseResult) {
			this.priority = (moneyNumber.getTimes() - 1) * this.numbers.size();
			for (String red : Constants.RED) {
				try {
					String field = "r" + red;
					String value = BeanUtils.getProperty(moneyNumber, field);
					if (StringUtils.isNotBlank(value)) {
						numbers.add(Integer.valueOf(value));
						this.priority += Integer.valueOf(BeanUtils.getProperty(analyseResult, field));
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

	}
}
