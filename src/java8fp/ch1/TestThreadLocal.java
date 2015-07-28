/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestThreadLocal.java
 * 2015年7月24日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */
package java8fp.ch1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.text.DateFormatter;

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月24日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestThreadLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final AtomicInteger nextId = new AtomicInteger(0);
		ThreadLocal<Integer> tl = ThreadLocal.withInitial(()->nextId.getAndIncrement());
		ThreadLocal<SimpleDateFormat> tldf = ThreadLocal.withInitial(
				()->new SimpleDateFormat("dd-MMM-yyyy"));
		
		System.out.println(tldf.get().format(new Date()));
	}

}

