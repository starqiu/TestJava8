/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * LookupDupicate3Number.java
 * 2015年8月26日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 实现功能： 一组整型数中，有一个数字重复3遍，其它数字重复2遍，请找出这个重复3遍的数字。<br/>
 * 比如：[88, 459, 5262, 88, -17, 677, 88, 677, -17, 459, 5262], 结果为88。<br/>
 * 要求程序代码中额外申请的空间为O(1)，请给出一个平均时间复杂度不大于O(nlogn)的算法。<br/>
 * 请首先用文字阐述答题思路，然后用Java程序实现。(阿里　2016)<br/>
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年8月26日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
@RunWith(ExtendedRunner.class)  
public class LookupDupicate3Number {

//	@Rule
//	public RepeatRule repeatRule = new RepeatRule();
	private static final Random rand = new Random();
	
	public static int lookupNumber(int[] arr){
		return lookupNumber(arr, 0, arr.length -1);
	}
	
	public static int lookupNumber(int[] arr, int start, int end){
		if (start == end) {//只有一个数
			return arr[start];
		}
		int i = partition(arr, start, end);
		if (i == end || arr[i] !=  arr[end]) {//如果选中的数字只有一个或者右边没有数字，则返回
			return arr[i];
		}
		if (((i - start) & 1) == 0) {//小于当前数的个数是偶数，则有３个数的在右边
			return  lookupNumber(arr, i + 1, end - 1);
		}else {
			return lookupNumber(arr, start, i-1);
		}
	}
	public static int partition(int[] arr,int start,int end){
		assert(start<end);
		int selectIndex = rand.nextInt(end - start+1) + start;
//		System.out.println(start+" "+ end + " " + selectIndex);
//		int selectIndex = end;
		int selectValue = arr[selectIndex];
		swap(arr, selectIndex, end);
		int i = start;
		int j = end - 1;
		while(i < j){
			while (arr[i] <= selectValue && i < j) {
				if (arr[i]==selectValue) {
					swap(arr, i, end-1);
					if (arr[i]==selectValue) {//防止死循环
						break;
					}
				}else {
					i++;
				}
			}
			while (arr[j]>=selectValue && i < j) {
				if (arr[j]==selectValue) {
					swap(arr, j, end-1);
				}
				j--;
			}
			while (arr[i] < selectValue && i <= j) {
				i++;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, i, end);
		if (arr[end-1] ==  selectValue) {
			swap(arr, end-1, end);
		}
//		printArray(arr);
		return i;
		
	}
	
	public static void swap(int[] arr,int i,int j){
		if (i == j) {
			return;
		}
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static int xorArray(int[] arr){
		int result = 0;
		for (int i : arr) {
			result ^= i;
		}
		return result;
	}
	
//	@Test
	public void testXorArray(){
		int[] arr = {88, 459, 5262, 88, -17, 677, 88, 677, -17, 459, 5262};
		assertEquals(88, xorArray(arr));
	}
	
//	@Test
	public void testSwap(){
		int[] arr = {2,3,2};
		swap(arr, 0, 1);
		assertEquals(3, arr[0]);
		assertEquals(2, arr[1]);
		swap(arr, 1, 2);
		assertEquals(2, arr[1]);
		assertEquals(2, arr[2]);
	}
	
//	@Test
	public void testPartitiion(){
		int[] arr = {2,4,3};
		int i = partition(arr, 0, 2);
		assertEquals(1, i);
		assertEquals(2, arr[0]);
		assertEquals(3, arr[1]);
		assertEquals(4, arr[2]);
		
		int[] arr1 = {2,4,3,3};
		int i1 = partition(arr1, 0, 3);
		assertEquals(1, i1);
		assertEquals(2, arr1[0]);
		assertEquals(3, arr1[1]);
		assertEquals(3, arr1[2]);
		assertEquals(4, arr1[3]);
	}
	
//	@Test
//	@Repeat(1000)
	public void testLookup(){
//		int[] arr = {2,4,3,4,2,3,3};
		int[] arr = {-17, 88, 88, -17, 88};
		int i = lookupNumber(arr);
		assertEquals(88, i);
//		System.out.println("tt");
	}
	@Test
	@Repeat(40000)
	public void testLookup2(){
		int[] arr = {88, 459, 5262, 88, -17, 677, 88, 677, -17, 459, 5262};
		int i = lookupNumber(arr);
		assertEquals(88, i);
//		System.out.println("t===========================t");
	}
	
	
}

