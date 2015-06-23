import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Closure.java
 * 2015年6月19日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 闭包
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年6月19日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestClosure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] arr = {"hello","world","gfsd","hgw","qetu","hcslgp"};
		
		List<String> list = Arrays.asList(arr);
		
		Predicate<String> startWithH = (String name) ->name.startsWith("h");
		
		long result =-1;
		result = list.stream().filter(startWithH).count();
		System.out.println(result);
		
		long result1 =-1;
		result1 = list.stream().filter(checkIfStartWith("h")).count();
		System.out.println(result1);
		
		
		Function<String, Predicate<String>> startWithLetter = letter ->name -> name.startsWith(letter) ;
		long result2 =-1;
		result2 = list.stream()
				.filter(startWithLetter.apply("h")).count();
		System.out.println(result2);
		
	}
	
	static Predicate<String> checkIfStartWith(String letter){
		return name-> name.startsWith(letter);
	}

}

