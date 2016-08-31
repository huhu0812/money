package com.money.utils.cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;

public class CacheFactory {

	private static Logger logger = Logger.getLogger(CacheFactory.class);

	private static Map<String, CacheWrapper> hashMapWrapper = new HashMap<String, CacheWrapper>();

	private static final String DEFAULT_NAME = "default_cache";

	/**
	 * 获取一个名称为cacheName的缓存对象；如果不存在，返回null
	 * 
	 * @param cacheName
	 * @return
	 */
	public static CacheWrapper getCacheWrapper(String cacheName) {
		logger.debug("Get CacheWrapper, The cacheName is : " + cacheName);
		CacheWrapper cacheWrapper = hashMapWrapper.get(cacheName);
		if (cacheWrapper == null) {
			cacheName = StringUtils.isNotBlank(cacheName) ? cacheName : DEFAULT_NAME;
			initCache(cacheName);
			cacheWrapper = hashMapWrapper.get(cacheName);
		}
		return cacheWrapper;
	}

	/**
	 * 清理所有的缓存
	 */
	public static void clearCache() {
		Object[] cacheArray = hashMapWrapper.keySet().toArray();
		for (int i = 0, l = cacheArray.length; i < l; i++) {
			try {
				String cacheName = cacheArray[i].toString();
				logger.debug("The cache is below to clear, And the name is : " + cacheName);
				CacheWrapper cacheWrapper = hashMapWrapper.get(cacheName);
				cacheWrapper.jcsCache.clear();
			} catch (CacheException e) {
				logger.debug("Clear Cache Error!");
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取一个名称为cacheName的缓存对象；如果不存在，则创建一个新的缓存对象
	 * 
	 * @param cacheName
	 * @return
	 */
	private static CacheWrapper createCacheWrapper(String cacheName) {
		JCS cache = null;
		try {
			cache = JCS.getInstance(cacheName);
			return new CacheWrapper(cache);
		} catch (CacheException e) {
			return null;
		}
	}

	/**
	 * 创建缓存对象
	 * 
	 * @param cacheName
	 */
	private static void createHashMapWrapper(String cacheName) {
		hashMapWrapper.put(cacheName, createCacheWrapper(cacheName));
	}

	/**
	 * 初始化缓存对象
	 */
	public static void initCache(String cacheName) {
		logger.debug("By Start initCache Method, We create all the Cache Object");
		createHashMapWrapper(cacheName);
	}
}
