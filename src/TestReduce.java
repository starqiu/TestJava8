import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestReduce.java
 * 2015年6月19日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年6月19日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestReduce {
	
	public static void main(String[] args) {
		int[] arr = {4,7,1,3,9};
		
		int result =  Arrays.stream(arr).reduce(0, (e1,e2)->e1+e2);
		
		System.out.println(result);
		
		String[] friends = {"Brian","Nate","Neal","Raju","Sara","Scott"};
		int result2 = Arrays.stream(friends).mapToInt(name->name.length()).sum();
		System.out.println(result2);
		
		System.out.println(String.join(",", friends));
		
		System.out.println(
				Arrays.stream(friends)
				.map(String::toUpperCase)
				.collect(Collectors.joining(",") )
				);
	}

}

