import java.util.stream.Stream;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Test.java
 * 2015年7月2日
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
 *2015年7月2日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Test {

	public static void main(String[] args) {
		Integer[] arr = {1,4,2,5,2};
		Stream.of(arr).forEach(System.out::println);
	}
}

