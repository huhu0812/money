package com.money.utils.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CacheFactoryTest {

	@Test
	public void testput() {
		CacheFactory.getCacheWrapper("test").put("key", "value");

		String value = (String) CacheFactory.getCacheWrapper("test").get("key");
		assertNotNull(value);
		assertEquals("value", value);
	}
}
