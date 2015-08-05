/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Increment.java
 * 2015年7月30日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

/**
 * 实现功能： Java的中间缓存机制
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月30日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Increment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int j=0;
		for (int i = 0; i <100; i++) {
//			j=j++; //0
//			j=++j;//100
			j++;//100
		}
		System.out.println(j);
		int t = "abc".length();
//		char c = 17c; //wrong
		System.out.println(Character.getNumericValue('6'));
	}

}

