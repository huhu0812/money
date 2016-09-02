package com.money.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RedTest {

	@Test
	public void testConstructor() {
		List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"03","01","04","02"})) ;
		Red red=new Red(list);
		System.out.println(red.getNumber());
	}
}
