package com.money.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.money.service.IOriginalNumberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class OriginalNumberServiceImplTest {
	@Autowired
	private IOriginalNumberService service;

	@Test
	public void testinit() {
		this.service.initAllNumber();
	}
}
