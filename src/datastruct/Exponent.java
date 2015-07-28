/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Exponent.java
 * 2015年7月27日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

/**
 * 实现功能： 快速计算一个正整数的n次方
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月27日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Exponent {

	public  static long exp(long base , int exponent){
		long result = 1;
		
		if (exponent == 0) {
			return 1;
		}else if (exponent == 1) {
			return base;
		}
		
		result = exp(base, exponent>>1);
		result *= result;
		if (1 == (exponent & 1)) {
			result *= base;
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(exp(2, 48));
//		System.out.println(Math.pow(2, 48));
	}

}

