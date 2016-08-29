package com.money.service;

import com.money.model.HistoryNumber;

public interface IMoneyNumberService {

	public void uploadHistoryData(String filePath);

	public void insertNewOne(HistoryNumber historyNumber);
}
