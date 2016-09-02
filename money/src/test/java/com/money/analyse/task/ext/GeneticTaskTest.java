package com.money.analyse.task.ext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.beanutils.BeanUtils;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.money.entities.AnalyseResult;
import com.money.entities.Red;
import com.money.repository.AnalyseResultRepository;
import com.money.repository.RedRepository;
import com.money.utils.Constants;
import com.money.utils.enums.AppeareType;

@RunWith(EasyMockRunner.class)
public class GeneticTaskTest {

	@TestSubject
	private GeneticTask task = new GeneticTask();

	@Mock
	private AnalyseResultRepository analyseResultRepository;

	@Mock
	private RedRepository redRepository;

	@Test
	public void testexecute() {
		List<AnalyseResult> resultList = new ArrayList<AnalyseResult>();
		AnalyseResult result = new AnalyseResult();
		result.setType(AppeareType.ALL);
		for (int i = 0; i < Constants.RED.length; i++) {
			try {
				BeanUtils.setProperty(result, "r" + Constants.RED[i], i + 1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < Constants.BLUE.length; i++) {
			try {
				BeanUtils.setProperty(result, "b" + Constants.BLUE[i], i + 1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		resultList.add(result);
		EasyMock.expect(this.analyseResultRepository.findByType((AppeareType) EasyMock.anyObject()))
				.andReturn(resultList);

		List<Red> numberList = new ArrayList<Red>();
		Red number = new Red();
		number.setNumber("01,02,03,04,05,06");
		numberList.add(number);

		number = new Red();
		number.setNumber("01,02,03,04,05,07");
		numberList.add(number);

		number = new Red();
		number.setNumber("01,02,03,04,05,08");
		numberList.add(number);

		number = new Red();
		number.setNumber("01,02,03,04,05,09");
		numberList.add(number);

		number = new Red();
		number.setNumber("01,02,03,04,05,10");
		numberList.add(number);
		EasyMock.expect(this.redRepository.findAll()).andReturn(numberList);

		EasyMock.replay(this.analyseResultRepository, this.redRepository);
		task.execute(new Consumer<List<AnalyseResult>>() {
			public void accept(List<AnalyseResult> t) {
				for (AnalyseResult result : t) {
					System.out.println(result);
				}
			}
		});
	}
}
