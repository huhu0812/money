package com.money.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.money.entities.Red;
import com.money.repository.RedRepository;
import com.money.service.IRedService;
import com.money.utils.Constants;

@Service
public class RedServiceImpl implements IRedService {

	@Resource
	private RedRepository redRepository;

	private Set<String> exist = new HashSet<String>();

	@Override
	public void initRed() {
		long start = System.currentTimeMillis();
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
			if (!isLong && result.size() == 6 && exist.add(result.toString())) {
				try {
					this.redRepository.save(new Red(result));
					number++;
					if (number % 10000 == 0) {
						System.out
								.println("Saved " + number + " records, time:" + (System.currentTimeMillis() - start));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
