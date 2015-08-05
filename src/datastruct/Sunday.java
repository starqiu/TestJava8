/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Sunday.java
 * 2015年7月31日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package datastruct;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月31日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Sunday {
	
	private int court ;
	Sunday(int court){
		this.court = court;
	}
	
	public static int sum(int... nums){
		int sum =0;
		for (int i : nums) {
			sum +=i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Sunday sunday = new Sunday(99);
		System.out.println(sunday.court);
		
		System.out.println(Sunday.sum());
		
	}

	
}

