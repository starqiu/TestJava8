/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * ListAll.java
 * 2015年8月1日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.security.auth.kerberos.KerberosKey;

/**
 * 实现功能：求一个数组的全排列
 * <p>
 * date author email notes<br />
 * -------- --------------------------- ---------------<br />
 * 2015年8月1日 邱星 starqiu@mail.ustc.edu.cn 新建类<br />
 * </p>
 *
 */
public class ListAll {

	public static long listAllCombines(String[] arr, int len) throws Exception {
		return listAllCombines(arr, 0, len);
	}

	public static long listAllCombines(String[] arr, int len,
			Predicate<String[]> condition) throws Exception {
		return listAllCombines(arr, 0, len, condition);
	}

	/**
	 * @param arr
	 *            待打印的数组
	 * @param start
	 *            数组起始位置
	 * @param totalLength
	 *            总共需要打印的长度
	 * @return
	 */
	public static long listAllCombines(String[] arr, int start, int totalLength)
			throws Exception {
		long size = 0;

		if (null == arr) {
			throw new Exception("array can not be null!");
		}

		int len = arr.length;

		if (totalLength > len) {
			return 0;
		}

		for (int i = start; i < len; i++) {
			if (start == totalLength - 1) { // 长度满足
//				System.out.println(String.join(",", Arrays.copyOfRange(arr, 0,  totalLength)));
				size++;
			} else {
				swap(arr, start, i);
				size += listAllCombines(arr, start + 1, totalLength);
				swap(arr, start, i);
			}
		}

		return size;
	}

	public static long listAllCombines(String[] arr, int start,
			int totalLength, Predicate<String[]> condition) throws Exception {
		long size = 0;

		if (null == arr) {
			throw new Exception("array can not be null!");
		}

		int len = arr.length;

		if (totalLength > len) {
			return 0;
		}

		for (int i = start; i < len; i++) {
			if (start == totalLength - 1
					&& condition.test(Arrays.copyOfRange(arr, 0, totalLength))) { // 长度满足
//				System.out.println(String.join(",", Arrays.copyOfRange(arr, 0, totalLength)));
				size++;
			} else {
				swap(arr, start, i);
				size += listAllCombines(arr, start + 1, totalLength);
				swap(arr, start, i);
			}
		}

		return size;
	}

	public static long listAllCombinesWithFixedSort(String[] arr, int start,
			int end, int totalLength, Stack<String> stack) throws Exception {
		long size = 0;

		if (null == arr) {
			throw new Exception("array can not be null!");
		}

		int len = arr.length;

		if (totalLength > len) {// 总元素不足
			return 0;
		}

		if (end < start) {// 剩余元素不足
			return 0;
		}

		for (int i = start; i <= end; i++) {
			stack.push(arr[i]);
			if (stack.size() == totalLength) { // 长度满足
			// stack.forEach(x -> System.out.printf("%s,", x));
			// System.out.println();
				size++;
			} else {
				int newEnd = len - totalLength + stack.size();// 最大开始元素
				size += listAllCombinesWithFixedSort(arr, i + 1, newEnd,
						totalLength, stack);
			}
			stack.pop();
		}
		return size;
	}
	public static long listAllCombinesWithFixedSortAndCondition(String[] arr, int start,
			int end, int remainedCount, Stack<String> stack, Predicate<String[]> condition) throws Exception {
		long size = 0;
		
		if (null == arr) {
			throw new Exception("array can not be null!");
		}
		
		int len = arr.length;
		
		if (remainedCount > len) {// 总元素不足
			return 0;
		}
		
		if (end < start) {// 剩余元素不足
			return 0;
		}
		
		for (int i = start; i <= end; i++) {
			stack.push(arr[i]);
			if (stack.size() == remainedCount ) { // 长度满足
				if (condition.test(stack.toArray(new String[remainedCount]))) {//条件满足
//					stack.forEach(x -> System.out.printf("%s,", x));
//					System.out.println();
					size++;
				}
			} else {
				int newEnd = len - remainedCount + stack.size();// 最大开始元素
				size += listAllCombinesWithFixedSortAndCondition(arr, i + 1, newEnd,
						remainedCount, stack,condition);
			}
			stack.pop();
		}
		return size;
	}

	public static long listAllCombinesWithFixedSort(String[] arr,
			int totalLength) throws Exception {
		long size = 0;
		int end = arr.length - totalLength;
		Stack<String> stack = new Stack<String>();
		size = listAllCombinesWithFixedSort(arr, 0, end, totalLength, stack);
		return size;
	}
	
	public static long listAllCombinesWithFixedSortAndCondition(String[] arr,
			int totalLength, Predicate<String[]> condition) throws Exception {
		long size = 0;
		int end = arr.length - totalLength;
		Stack<String> stack = new Stack<String>();
		size = listAllCombinesWithFixedSortAndCondition(arr, 0, end, totalLength, stack,condition);
		return size;
	}

	/**
	 * 交换数组中两个元素的位置
	 */
	public static void swap(String[] arr, int i, int j) {
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static String[] createStringArrayWithRange(int from, int to) {
		String[] result = new String[to - from];
		for (int i = from; i < to; i++) {
			result[i - from] = String.valueOf(i);
		}
		return result;
	}

	public static String[] createStringArrayWithMaxValue(int to) {
		return createStringArrayWithRange(0, to);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ListAll listAll = new ListAll();
		// String[] arr = { "1", "2", "3", "4", "5" };
//		long count = listAllCombinesWithFixedSortAndCondition(
//				createStringArrayWithRange(1, 101), 53 , x -> Stream.of(x).mapToInt(Integer::valueOf).sum() < 100);
//		System.out.println(count);

		// Stack<String> stack = new Stack<String>();
		// System.out.println(Arrays.toString(createStringArrayWithRange(1,
		// 5)));

		// stack.push("1");
		// stack.push("2");
		// stack.push("3");
		//
		//
		// stack.forEach(x -> System.out.println(x)); // 1 2 3
		long count = 0;
		for (int x1 = 1; x1 <=100/5; x1++) {
			for (int x2 = x1+1; x2 <=100; x2++) {
				for (int x3 = x2+1; x3 <=100; x3++) {
					for (int x4 = x3+1; x4 <=100; x4++) {
						for (int x5 = x4+1; x5 <=100; x5++) {
							if (x1+x2+x3+x4+x5 < 100) {
								System.out.printf("%d %d %d %d %d \n",x1,x2,x3,x4,x5);
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		
		for (int i = 0; i <10; i++) 
			System.out.println(i);
	}
	
}
