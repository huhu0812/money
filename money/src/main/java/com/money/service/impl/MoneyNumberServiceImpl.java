package com.money.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.entities.MoneyNumber;
import com.money.entities.OriginalNumber;
import com.money.model.HistoryNumber;
import com.money.repository.MoneyNumberRepository;
import com.money.repository.OriginalNumberRepository;
import com.money.service.IMoneyNumberService;
import com.money.utils.excel.ExcelReader;

@Service
public class MoneyNumberServiceImpl implements IMoneyNumberService {

	@Resource
	private MoneyNumberRepository moneyNumberRepository;

	@Resource
	private OriginalNumberRepository originalNumberRepository;

	public void uploadHistoryData(String filePath) {
		ExcelReader.readExcel(filePath, new Consumer<List<String>>() {
			public void accept(List<String> dataList) {
				MoneyNumber moneyNumber = new MoneyNumber();
				moneyNumber.setDate(dataList.get(0));
				moneyNumber.setIndex(dataList.get(1));
				OriginalNumber originalNumber = originalNumberRepository.findByRedCombinedAndBlue(
						dataList.subList(2, dataList.size() - 1).toString(), dataList.get(dataList.size() - 1));
				if (originalNumber == null) {
					return;
				}
				moneyNumber.setNumber(originalNumber);
				moneyNumberRepository.save(moneyNumber);
			}
		});
	}

	public void insertNewOne(HistoryNumber historyNumber) {
		historyNumber.getNumbers().sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o2);
			}
		});
		OriginalNumber originalNumber = originalNumberRepository.findByRedCombinedAndBlue(
				historyNumber.getNumbers().subList(0, historyNumber.getNumbers().size() - 1).toString(),
				historyNumber.getNumbers().get(historyNumber.getNumbers().size() - 1));
		if (originalNumber == null) {
			return;
		}
		MoneyNumber moneyNumber = new MoneyNumber();
		moneyNumber.setNumber(originalNumber);
		moneyNumber.setIndex(historyNumber.getIndex());
		moneyNumber.setDate(historyNumber.getDate());
		this.moneyNumberRepository.save(moneyNumber);
	}
}
