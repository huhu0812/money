package com.money.utils.cache;

import java.io.Serializable;

public interface Cacheable extends Serializable {

	public String getKey();
}
