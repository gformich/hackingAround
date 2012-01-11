package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	/**
	 * Returns the common set of items that are contained in both lists
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T> List<T> findIntersection(List<T> list1, List<T> list2) {
		
		List <T> intersectionList = new ArrayList<T>();
		
		for(T t1: list1) {
			for(T t2 : list2) {
				if(t2.equals(t1)) {
					intersectionList.add(t1);
				}
			}
		}
		return intersectionList;
	}

}
