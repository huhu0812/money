package com.money.repository;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.money.entities.Red;
import com.money.utils.CacheList;

public class BaseRedRepository {

	@Resource(name = "entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;

	@SuppressWarnings("unchecked")
	public CacheList<Red> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select red from Red red", Red.class);
		List<Red> resultList = query.getResultList();
		CacheList<Red> cacheList = new CacheList<Red>();
		for (Red red : resultList) {
			cacheList.add(red);
		}
		return cacheList;
	}
}
