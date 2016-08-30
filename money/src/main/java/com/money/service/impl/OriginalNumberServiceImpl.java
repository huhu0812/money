package com.money.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.repository.OriginalNumberRepository;
import com.money.service.IOriginalNumberService;
import com.money.utils.Constants;
import com.money.utils.ConstructUtil;

@Service
public class OriginalNumberServiceImpl implements IOriginalNumberService {

	@Resource
	private OriginalNumberRepository repository;

	public void initAllNumber() {
		long stattime = System.currentTimeMillis();
		int nCnt = Constants.RED.length;
		long nBit = -1L >>> 63 - nCnt;
		long number = 0;
		for (int i = 1; i <= nBit; i++) {
			List<String> result = new ArrayList<String>(6);
			boolean isLong = false;
			for (int j = 0; j < nCnt; j++) {
				if (result.size() > 6) {
					isLong = true;
					break;
				}
				if (i << 63 - j >> 63 == -1) {
					result.add(Constants.RED[j]);
				}
			}
			if (!isLong && result.size() == 6) {
				for (List<String> temp : ConstructUtil.constructNumber(result)) {
					try {
						this.repository.save(ConstructUtil.constructOriginalNumber(temp));
						number++;
						if (number % 1000 == 0) {
							System.out.println(
									"Generate " + number + " records, time:" + (System.currentTimeMillis() - stattime));
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(temp.toString());
					}
				}
			}
		}
	}
}
