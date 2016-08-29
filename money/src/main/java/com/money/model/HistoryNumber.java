package com.money.model;

import java.util.ArrayList;
import java.util.List;

public class HistoryNumber {

	private String date;

	private String index;

	private List<String> numbers = new ArrayList<String>();

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}
}
