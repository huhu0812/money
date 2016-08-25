package com.money.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class AnalyseResultRepositoryTest {
	@Autowired
	public AnalyseResultRepository repository;

	@Test
	public void testcountByRang() throws Exception {
		List<Object[]> result = this.repository.queryEach();
		for (Object[] temp : result) {
			for (Object obj : temp) {
				System.out.println(obj);
			}
		}
		System.out.println(result);
	}
}
