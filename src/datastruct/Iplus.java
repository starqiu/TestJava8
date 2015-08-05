/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * Iplus.java
 * 2015年7月30日
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
 *2015年7月30日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class Iplus {

	
	static{
		int x =5; //local var
	}
	static int x,y;
	
	public static void myMethod(){
		y = x++ + ++x;
		System.out.println(x);
		System.out.println(y);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		x--;
		
		myMethod();
		
		System.out.println(x + y++ +x);//2
	}

}

