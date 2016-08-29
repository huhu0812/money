package com.money.service.impl;

import java.util.Comparator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.entities.MoneyNumber;
import com.money.entities.OriginalNumber;
import com.money.model.HistoryNumber;
import com.money.repository.MoneyNumberRepository;
import com.money.repository.OriginalNumberRepository;
import com.money.service.IMoneyNumberService;

@Service
public class MoneyNumberServiceImpl implements IMoneyNumberService {

	@Resource
	private MoneyNumberRepository moneyNumberRepository;

	@Resource
	private OriginalNumberRepository originalNumberRepository;

	public void uploadHistoryData(String filePath) {
		//TODO: read excel file and get the history data
	}

	public void insertNewOne(HistoryNumber historyNumber) {
		historyNumber.getNumbers().sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o2);
			}
		});
		OriginalNumber originalNumber = originalNumberRepository
				.findByCombinedNumber(historyNumber.getNumbers().toString());
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
