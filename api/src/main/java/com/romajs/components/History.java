package com.romajs.components;

import java.util.Iterator;
import java.util.List;

public class History<T> implements Iterable<T> {

	public static <T> History<T> from(List<T> list) {
		return new History<T>(list);
	}

	private List<T> list;

	public History() {
		super();
	}

	public History(List<T> list) {
		super();
		this.list = list;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}