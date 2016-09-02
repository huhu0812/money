package com.money.analyse.task.ext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.money.analyse.task.BaseTask;
import com.money.analyse.task.ext.thread.CountNumberThread;
import com.money.entities.AnalyseResult;
import com.money.entities.MoneyNumber;
import com.money.utils.Constants;
import com.money.utils.ConstructUtil;
import com.money.utils.enums.AppeareType;

@Component("countNumberTask")
public class CountNumberTask extends BaseTask {

	private Map<String, Integer> countMap = ConstructUtil.getInitCountMap();

	public void execute(Consumer<List<AnalyseResult>> consumer) {
		this.analyseAll();
		this.analyseCommon();
	}

	private void analyseAll() {
		List<AnalyseResult> results = this.analyseResultRepository.findByType(AppeareType.ALL);
		if (CollectionUtils.isEmpty(results)) {
			AnalyseResult inserted = new AnalyseResult();
			Object[] countResult = this.analyseResultRepository.queryEach().get(0);
			int index = 0;
			for (int i = 0; i < Constants.RED.length; i++) {
				try {
					BeanUtils.setProperty(inserted, "r" + Constants.RED[i], countResult[index]);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				index++;
			}
			for (int i = 0; i < Constants.BLUE.length; i++) {
				try {
					BeanUtils.setProperty(inserted, "b" + Constants.RED[i], countResult[index]);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				index++;
			}
			inserted.setType(AppeareType.ALL);
			this.analyseResultRepository.save(inserted);
			return;
		}
		Sort sort = new Sort(Sort.Direction.DESC, new String[] { "index" });
		Pageable pageable = new PageRequest(0, 1, sort);
		Page<MoneyNumber> page = this.moneyNumberRepository.findAll(pageable);
		AnalyseResult updated = results.get(0);
		Iterator<Entry<String, Integer>> iter = this.countMap.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			try {
				String value = BeanUtils.getProperty(page.getContent().get(0), entry.getKey());
				if (StringUtils.isNotBlank(value)) {
					int count = Integer.valueOf(BeanUtils.getProperty(updated, entry.getKey()));
					BeanUtils.setProperty(updated, entry.getKey(), ++count);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		this.analyseResultRepository.save(updated);
	}

	private void analyseCommon() {
		Sort sort = new Sort(Sort.Direction.DESC, new String[] { "index" });
		Pageable pageable = new PageRequest(0, AppeareType.getMax().getNumber(), sort);
		Page<MoneyNumber> page = this.moneyNumberRepository.findAll(pageable);
		final List<AnalyseResult> analyseResult = new ArrayList<AnalyseResult>();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (AppeareType type : AppeareType.values()) {
			Runnable runnable = new CountNumberThread(page.getContent(), type, new Consumer<AnalyseResult>() {
				public void accept(AnalyseResult t) {
					analyseResult.add(t);
				}
			});
			executorService.execute(runnable);
		}
	}

}
