/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestComparator.java
 * 2015年7月24日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package java8fp.ch2;

import java.util.Comparator;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月24日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Integer> ic = (i1,i2)->i1-i2;
	}

}

