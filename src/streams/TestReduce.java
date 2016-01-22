package streams;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestReduce.java
 * 2015å¹?6æœ?19æ—?
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * å®žçŽ°åŠŸèƒ½ï¼? 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015å¹?6æœ?19æ—?	 é‚±æ˜Ÿ            starqiu@mail.ustc.edu.cn	      æ–°å»ºç±?<br /></p>
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
		
		
		int[] arr1 ={1,3,5,3,2,4,6,1,0,1};
		Arrays.stream(arr1)
				.filter(x->x!=0)
				.sorted()
				.forEach(System.out::println);
		
		int res = Arrays.stream(arr1)
										.reduce(0, Integer::sum);
		
		System.out.println(res +" == " + Arrays.stream(arr1).sum() );
	}

}

