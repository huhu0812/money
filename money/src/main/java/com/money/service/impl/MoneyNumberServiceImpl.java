package com.money.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.money.entities.MoneyNumber;
import com.money.entities.Red;
import com.money.model.HistoryNumber;
import com.money.repository.MoneyNumberRepository;
import com.money.repository.RedRepository;
import com.money.service.IMoneyNumberService;
import com.money.utils.excel.ExcelReader;

@Service
public class MoneyNumberServiceImpl implements IMoneyNumberService {

	@Resource
	private MoneyNumberRepository moneyNumberRepository;

	@Resource
	private RedRepository redRepository;

	public void uploadHistoryData(String filePath) {
		ExcelReader.readExcel(filePath, new Consumer<List<String>>() {
			public void accept(List<String> dataList) {
				MoneyNumber moneyNumber = new MoneyNumber();
				moneyNumber.setDate(dataList.get(0));
				moneyNumber.setIndex(dataList.get(1));
				moneyNumber.setBlue(dataList.get(dataList.size() - 1));
				List<String> redNumbers = dataList.subList(2, dataList.size() - 1);
				String numbers = redNumbers.stream().collect(Collectors.joining(","));
				Red red = redRepository.findByNumber(numbers);
				if (red != null) {
					redNumbers.forEach(redNumber -> {
						try {
							BeanUtils.setProperty(moneyNumber, "r" + redNumber, redNumber);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
					moneyNumberRepository.save(moneyNumber);
				}
			}
		});
	}

	public void insertNewOne(HistoryNumber historyNumber) {
		historyNumber.getNumbers().sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o2);
			}
		});
		List<String> redNumbers = historyNumber.getNumbers().subList(0, historyNumber.getNumbers().size() - 1);
		String numbers = redNumbers.stream().collect(Collectors.joining(","));
		Red red = redRepository.findByNumber(numbers);
		if (red != null) {
			MoneyNumber moneyNumber = new MoneyNumber();
			moneyNumber.setRed(red);
			moneyNumber.setIndex(historyNumber.getIndex());
			moneyNumber.setDate(historyNumber.getDate());
			moneyNumber.setBlue(historyNumber.getNumbers().get(historyNumber.getNumbers().size() - 1));
			redNumbers.forEach(redNumber -> {
				try {
					BeanUtils.setProperty(moneyNumber, "r" + redNumber, redNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			moneyNumberRepository.save(moneyNumber);
		}

	}
}
