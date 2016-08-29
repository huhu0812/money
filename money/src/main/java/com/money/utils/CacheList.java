package com.money.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

import com.money.utils.cache.CacheFactory;
import com.money.utils.cache.CacheWrapper;
import com.money.utils.cache.Cacheable;

public class CacheList<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> elementList = new ArrayList<String>();

	private CacheWrapper cacheWrapper;

	private String getKey(E e) {
		if (e instanceof Cacheable) {
			Cacheable cache = (Cacheable) e;
			return cache.getKey();
		}
		return null;
	}

	public CacheList() {
		cacheWrapper = CacheFactory.getCacheWrapper(null);
	}

	public CacheList(List<E> cacheList) {
		for (int i = 0; i < cacheList.size(); i++) {
			this.add(cacheList.get(i));
		}
	}

	@Override
	public void trimToSize() {
		super.trimToSize();
	}

	@Override
	public void ensureCapacity(int minCapacity) {
		super.ensureCapacity(minCapacity);
	}

	@Override
	public int size() {
		return elementList.size();
	}

	@Override
	public boolean isEmpty() {
		return elementList.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return elementList.contains(o);
	}

	@Override
	public int indexOf(Object o) {
		return elementList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return elementList.lastIndexOf(o);
	}

	@Override
	public Object clone() {
		return super.clone();
	}

	@Override
	public Object[] toArray() {
		return elementList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return elementList.toArray(a);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		String key = this.elementList.get(index);
		return (E) this.cacheWrapper.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) {
		String key = getKey(element);
		this.cacheWrapper.put(key, element);
		this.elementList.set(index, key);
		return (E) this.cacheWrapper.get(key);
	}

	@Override
	public boolean add(E e) {
		String key = getKey(e);
		this.cacheWrapper.put(key, e);
		return this.elementList.add(key);
	}

	@Override
	public void add(int index, E element) {
		String key = getKey(element);
		this.cacheWrapper.put(key, element);
		this.elementList.add(index, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		String key = this.elementList.remove(index);
		return (E) this.cacheWrapper.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		E e = (E) o;
		return this.elementList.remove(this.getKey(e));
	}

	@Override
	public void clear() {
		this.elementList.clear();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E e : c) {
			this.add(e);
		}
		return true;
	}

	@Override
	@Deprecated
	public boolean addAll(int index, Collection<? extends E> c) {
		return super.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (int i = 0; i < c.size(); i++) {
			this.remove(i);
		}
		return true;
	}

	@Override
	@Deprecated
	public boolean retainAll(Collection<?> c) {
		return super.retainAll(c);
	}

	@Override
	@Deprecated
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return super.listIterator(index);
	}

	@Override
	@Deprecated
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return super.listIterator();
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}

	@Override
	@Deprecated
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return super.subList(fromIndex, toIndex);
	}

	public void subCacheList(int fromIndex, int toIndex) {
		this.elementList.subList(fromIndex, toIndex);
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		Objects.requireNonNull(action);
		for (int i = 0; i < this.elementList.size(); i++) {
			action.accept(this.get(i));
		}
	}

	/**
	 * An optimized version of AbstractList.Itr
	 */
	private class Itr implements Iterator<E> {
		int cursor; // index of next element to return
		int lastRet = -1; // index of last element returned; -1 if no such

		public boolean hasNext() {
			return cursor != elementList.size();
		}

		public E next() {
			if (cursor >= elementList.size()) {
				throw new NoSuchElementException();
			}
			cursor++;
			return get(lastRet = cursor);
		}

		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			try {
				elementList.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

	}

}
