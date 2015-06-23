/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestString.java
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
public class TestString {
	
	public static void main(String[] args) {
		final String str = "w00t";
		
		str.chars().forEach(System.out::println);
		str.chars().forEach(TestString::printChar);
		
	}

	
	private static void printChar(int ch) {
		System.out.println((char)ch);
	}
}

